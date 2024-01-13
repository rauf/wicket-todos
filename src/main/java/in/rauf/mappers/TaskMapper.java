package in.rauf.mappers;

import in.rauf.entities.TaskEntity;
import in.rauf.models.Task;

public class TaskMapper {

    public static Task mapEntity(TaskEntity entity) {
        var task = new Task();
        task.setId(entity.getId());
        task.setName(entity.getName());
        task.setStatus(entity.getStatus());
        task.setPriority(entity.getPriority());
        task.setDueDate(entity.getDueDate());
        task.setCreatedAt(entity.getCreatedAt());
        task.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getAssignedTo() != null) {
            task.setAssignedTo(UserMapper.mapEntity(entity.getAssignedTo()));
        }
        if (entity.getProperty() != null) {
            task.setProperty(PropertyMapper.mapEntity(entity.getProperty()));
        }
        return task;
    }

    public static TaskEntity mapModel(Task task) {
        var taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setName(task.getName());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setDueDate(task.getDueDate());
        taskEntity.setCreatedAt(task.getCreatedAt());
        taskEntity.setUpdatedAt(task.getUpdatedAt());

        if (task.getAssignedTo() != null) {
            taskEntity.setAssignedTo(UserMapper.mapModel(task.getAssignedTo()));
        }
        if (task.getProperty() != null) {
            taskEntity.setProperty(PropertyMapper.mapModel(task.getProperty()));
        }
        return taskEntity;
    }
}
