package com.eci.cosw.springbootsecureapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eci.cosw.springbootsecureapi.entities.Task;
import com.eci.cosw.springbootsecureapi.entities.User;

//@Service
public interface TaskService {
	
	Task getTaskById(int taskId);
	List<Task> getTasksByUser(int UserId);
	List<Task> getTaskByUsername(String Username);
	List<Task> getTasks();
	Task modifyTaskUser(int idTask, User user);
	Task newTask(Task task);
	Task updateTask(Task newtask);
	Task removeTask(int taskId);

}
