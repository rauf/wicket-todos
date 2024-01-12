package in.rauf.models;

import java.time.Instant;
import java.util.Date;

public class Task {

    private Long id;
    private String name;
    private TaskStatus status;
    private TaskPriority priority;
    private Long assignedToUserId;
    private Date dueDate;
    private Long buildingId;
    private Instant createdAt;
    private Instant updatedAt;


    public Task() {
    }

    public Task(Long id, String name, TaskStatus status, TaskPriority priority,
                Long assignedToUserId, Date dueDate, Long buildingId,
                Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.assignedToUserId = assignedToUserId;
        this.dueDate = dueDate;
        this.buildingId = buildingId;
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

    public Long getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
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