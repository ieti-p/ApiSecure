package com.eci.cosw.springbootsecureapi.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Component;
import com.eci.cosw.springbootsecureapi.controller.TaskController;
import com.eci.cosw.springbootsecureapi.entities.Task;
import com.eci.cosw.springbootsecureapi.entities.User;
import org.springframework.stereotype.Service;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {
	
	private Map<Integer, Task> tasks = new HashMap<>();
	
	@Override
	public Task getTaskById(int taskId) {
		return tasks.get(taskId);
	}

	@Override
	public List<Task> getTasksByUser(int UserId) {
		 List<Task> list = new ArrayList<>();
	        for (int id : tasks.keySet()) {
	            Task task = tasks.get(id);
	            if (task.getUsuario().getId() == UserId){
	               list.add(task);
	            }
	        }
	        return list;
	}

	@Override
	public List<Task> getTaskByUsername(String Username) {
		List<Task> list = new ArrayList<>();
        for (int id : tasks.keySet()) {
            Task task = tasks.get(id);
            if (task.getUsuario().getUsername() == Username){
               list.add(task);
            }
        }
        return list;
	}

	@Override
	public List<Task> getTasks() {
		List<Task> list = new ArrayList<>();
        for (int id : tasks.keySet()) {
            list.add(tasks.get(id));
        }
        return list;
	}

	@Override
	public Task modifyTaskUser(int idTask, User user) {
		tasks.get(idTask).setUser(user);
        return tasks.get(idTask);
	}

	@Override
	public Task newTask(Task task) {
		int id=task.getId();
		tasks.put(id, task);
		return tasks.get(id);
	}

	@Override
	public Task updateTask(Task newtask) {
		int id=newtask.getId();
		tasks.replace(id, newtask);
		return tasks.get(id);
	}

	@Override
	public Task removeTask(int taskId) {
		Task t= tasks.get(taskId);
		tasks.remove(taskId);
		return t;
	}

}
