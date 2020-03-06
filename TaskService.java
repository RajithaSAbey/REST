package com.service;

import com.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTask();

    public Task getTask(int taskId);

    public Task addTask(Task task);

    public void updateTask(Task task);

    public void deleteTask(int taskId
    );
}
