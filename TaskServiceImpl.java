package com.service;

import com.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TaskServiceImpl  implements  TaskService{


    private static List<Task> tasks = new ArrayList<>();

    static {
        Task task1 = new Task(1, 001,"Task first", "taskAdmin1", "Deadline 1");
        Task task2 = new Task(2, 002,"Task second", "taskAdmin2", "Deadline 2");
        Task task3 = new Task(3, 003,"Task third", "taskAdmin3", "Deadline 3");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
    }

    @Override
    public List<Task> getAllTask() {
        return tasks;
    }

    @Override
    public Task getTask(int taskId) {

        for(Task task : tasks) {
            if(task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Task addTask(Task task) {

        int index=tasks.size() + 1;


        task.setTaskId(index);
        tasks.add(task);
        return task;
    }

    @Override
    public void updateTask(Task task) {
        for(Task oldTask : tasks) {
            if(oldTask.getTaskId() == task.getTaskId()) {
                oldTask.setTenantId(task.getTenantId());
                oldTask.setDescription(task.getDescription());
                oldTask.setOwnerOfTheTask(task.getOwnerOfTheTask());
                oldTask.setDeadline(task.getDeadline());
            }
        }
    }

    @Override
    public void deleteTask(int taskId) {
        for(Task t : tasks) {
            if(t.getTaskId() == taskId) {
                tasks.remove(t);
                break;
            }

        }
    }
}
