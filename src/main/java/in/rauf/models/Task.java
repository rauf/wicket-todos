package in.rauf.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Task implements Serializable {

    private Long id;
    private String name;
    private TaskStatus status;
    private TaskPriority priority;
    private String user;
    private Date dueDate;
    private String property;
    private Instant createdAt;
    private Instant updatedAt;


    public Task() {
    }

    public Task(Long id, String name, TaskStatus status, TaskPriority priority,
                String assignedToUserId, Date dueDate, String buildingId,
                Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.user = assignedToUserId;
        this.dueDate = dueDate;
        this.property = buildingId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}