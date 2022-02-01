package edu.escuelaing.lab2.parte2.data;

import edu.escuelaing.lab2.parte2.dto.Status;
import edu.escuelaing.lab2.parte2.dto.TaskDto;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private long id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private Date dueDate;
    private boolean create;
    AtomicLong atomicLong = new AtomicLong();

    public Task(TaskDto taskDto) {
        this.id = atomicLong.incrementAndGet();
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.dueDate = taskDto.getDueDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }
}
