package in.rauf.services;

import in.rauf.dao.TaskDao;
import in.rauf.mappers.TaskMapper;
import in.rauf.models.Task;

import java.io.Serializable;
import java.util.List;

public class TaskService implements Serializable {

    private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> fetchAllTasks() {
        var taskEntities = taskDao.findAll();

        return taskEntities.stream()
                .map(TaskMapper::mapEntity)
                .toList();
    }

    public void save(Task task) {
        var taskEntity = TaskMapper.mapModel(task);
        taskDao.persist(taskEntity);
    }
}
