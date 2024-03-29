package in.rauf.services.impl;

import in.rauf.components.taskfilter.TaskFilters;
import in.rauf.dao.TaskDao;
import in.rauf.mappers.TaskMapper;
import in.rauf.models.Task;
import in.rauf.models.TaskPriority;
import in.rauf.models.TaskStatus;
import in.rauf.services.TaskService;

import java.io.Serializable;
import java.util.List;

public class DefaultTaskService implements TaskService, Serializable {

    private final TaskDao taskDao;

    public DefaultTaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> fetchAllTasks() {
        var taskEntities = taskDao.findAll();

        return taskEntities.stream()
                .map(TaskMapper::mapEntity)
                .toList();
    }

    @Override
    public List<Task> fetchAllTasksForFilters(TaskFilters filters) {
        var propertyId = filters.getProperty() != null ? filters.getProperty().id() : null;
        var userId = filters.getUser() != null ? filters.getUser().id() : null;

        var taskEntities = taskDao.findAllFor(propertyId, userId);

        return taskEntities.stream()
                .map(TaskMapper::mapEntity)
                .toList();
    }

    @Override
    public void save(Task task) {
        var taskEntity = TaskMapper.mapModel(task);
        taskEntity.setStatus(TaskStatus.TODO);
        if (taskEntity.getPriority() == null) {
            taskEntity.setPriority(TaskPriority.MEDIUM);
        }
        taskDao.persist(taskEntity);
    }

    @Override
    public void updateStatus(Long id, TaskStatus taskStatus) {
        taskDao.updateStatus(id, taskStatus);
    }

    @Override
    public void delete(Long id) {
        taskDao.delete(id);
    }
}
