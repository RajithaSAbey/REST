package com.controller;

import com.model.Task;
import com.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;


    @GetMapping("/task/")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/task/{taskId}")
    public Task getTaskById(@PathVariable int taskId) {
        return taskService.getTask(taskId);
    }


    @PostMapping("/task/add")
    public ResponseEntity<Void> addTask(@RequestBody Task newTask, UriComponentsBuilder builder){
        Task task = taskService.addTask(newTask);

        if(task == null) {
            return ResponseEntity.noContent().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/task/{id}").buildAndExpand(task.getTaskId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/task/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task t = taskService.getTask(task.getTaskId());

        if(t == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        t.setTenantId(task.getTenantId());
        t.setDescription(task.getDescription());
        t.setOwnerOfTheTask(task.getOwnerOfTheTask());
        t.setDeadline(task.getDeadline());


        taskService.updateTask(t);
        return new ResponseEntity<Task>(t, HttpStatus.OK);
    }


    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable int taskId){
        Task t = taskService.getTask(taskId);

        if(t == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        taskService.deleteTask(taskId);
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    }

}
