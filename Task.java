package com.model;

public class Task {

    private int taskId;
    private int tenantId;
    private String description;
    private String ownerOfTheTask;
    private String deadline;

    public Task() {
        super();
    }
    public Task(int taskId, int tenantId, String description, String  ownerOfTheTask, String deadline) {
        super();
        this.taskId=taskId;
        this.tenantId=tenantId;
        this.description=description;
        this.ownerOfTheTask=ownerOfTheTask;
        this.deadline=deadline;

    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerOfTheTask() {
        return ownerOfTheTask;
    }

    public void setOwnerOfTheTask(String ownerOfTheTask) {
        this.ownerOfTheTask = ownerOfTheTask;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
