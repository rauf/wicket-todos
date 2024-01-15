package in.rauf.services;

import in.rauf.components.taskfilter.TaskFilters;
import in.rauf.models.Task;
import in.rauf.models.TaskStatus;

import java.io.Serializable;
import java.util.List;

public interface TaskService extends Serializable {

    List<Task> fetchAllTasks();

    List<Task> fetchAllTasksForFilters(TaskFilters filters);

    void save(Task task);

    void updateStatus(Long id, TaskStatus taskStatus);

    void delete(Long id);
}
