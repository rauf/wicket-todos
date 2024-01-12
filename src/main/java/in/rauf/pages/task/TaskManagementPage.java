package in.rauf.pages.task;

import in.rauf.components.tasklist.TaskList;
import in.rauf.layouts.main.MainLayout;
import in.rauf.models.Task;
import in.rauf.models.TaskPriority;
import in.rauf.models.TaskStatus;
import org.apache.wicket.model.Model;

import java.util.List;

public class TaskManagementPage extends MainLayout {

    public TaskManagementPage() {
        var taskList = new TaskList("taskList", Model.ofList(getAllTasks()));
        add(taskList);
    }

    private static List<Task> getAllTasks() {
        var task1 = new Task();
        task1.setId(1L);
        task1.setName("Task 1");
        task1.setStatus(TaskStatus.TODO);
        task1.setPriority(TaskPriority.MEDIUM);

        var task2 = new Task();
        task2.setId(2L);
        task2.setName("Task 2");
        task2.setStatus(TaskStatus.COMPLETED);
        task2.setPriority(TaskPriority.HIGH);

        return List.of(task1, task2);
    }

}
