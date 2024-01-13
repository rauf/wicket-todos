package in.rauf.services;

import in.rauf.dao.TaskDao;
import in.rauf.entities.TaskEntity;
import in.rauf.models.Task;

import java.util.List;

public class TaskService {

    private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> fetchAllTasks() {
        var taskEntities = taskDao.findAll();

        return taskEntities.stream()
                .map(this::mapTask)
                .toList();
    }

    public Task mapTask(TaskEntity entity) {
        var task = new Task();
        task.setId(entity.getId());
        task.setName(entity.getName());
        task.setStatus(entity.getStatus());
        task.setPriority(entity.getPriority());
        task.setDueDate(entity.getDueDate());
        task.setCreatedAt(entity.getCreatedAt());
        task.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getAssignedTo() != null) {
            task.setUser(entity.getAssignedTo().getName());
        }
        if (entity.getProperty() != null) {
            task.setProperty(entity.getProperty().getName());
        }
        return task;
    }
}
