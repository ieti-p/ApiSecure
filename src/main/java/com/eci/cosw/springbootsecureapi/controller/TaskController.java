package com.eci.cosw.springbootsecureapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eci.cosw.springbootsecureapi.service.impl.TaskServiceImpl;
import com.eci.cosw.springbootsecureapi.entities.Task;
@RestController
@RequestMapping(value = "/taskPlanner")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping(value = "/v1/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping(value = "/v1/tasks/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable String taskId) {
        Task task = taskService.getTaskById(Integer.parseInt(taskId));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/tasks")
    public ResponseEntity<Task> createTarea(@RequestBody Task task) {
        Task newTask = taskService.newTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/tasks")
    public ResponseEntity<Task> updateTarea(@RequestBody Task task) {
        Task taskUpdate = taskService.updateTask(task);
        return new ResponseEntity<>(taskUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/v1/tasks/{taskId}")
    public ResponseEntity<?> deleteTarea(@PathVariable String taskId) {
        Task temp= taskService.removeTask(Integer.parseInt(taskId));
        return new ResponseEntity<>("Removed task: "+temp, HttpStatus.OK);
    }

}
