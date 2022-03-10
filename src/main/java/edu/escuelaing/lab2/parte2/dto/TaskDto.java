package edu.escuelaing.lab2.parte2.dto;

import net.minidev.json.JSONObject;

import java.util.Date;

public class TaskDto {

    private String name;
    private String description;
    private Status status;
    private Date dueDate;

    public TaskDto(String name, String description, Status status, Date dueDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public TaskDto(JSONObject jsonObject) {
        this.name = jsonObject.getAsString("name");
        this.description = jsonObject.getAsString("description");
        this.status = Status.valueOf(jsonObject.getAsString("status"));
        this.dueDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
