package in.rauf.pages.task;

import in.rauf.components.taskform.OnSubmitListener;
import in.rauf.components.taskform.TaskForm;
import in.rauf.components.tasklist.OnStatusChangeListener;
import in.rauf.components.tasklist.TaskList;
import in.rauf.dao.PropertyDao;
import in.rauf.dao.TaskDao;
import in.rauf.dao.UserDao;
import in.rauf.layouts.main.MainLayout;
import in.rauf.models.Task;
import in.rauf.services.PropertyService;
import in.rauf.services.TaskService;
import in.rauf.services.UserService;
import org.apache.wicket.model.Model;

import java.io.Serializable;

public class TaskManagementPage extends MainLayout implements Serializable {

    private final TaskService taskService;
    private final PropertyService propertyService;
    private final UserService userService;

    public TaskManagementPage() {
        propertyService = new PropertyService(new PropertyDao());
        userService = new UserService(new UserDao());
        taskService = new TaskService(new TaskDao());

        OnSubmitListener<Task> onSubmitListener = taskService::save;
        OnStatusChangeListener onStatusChangeListener = taskService::updateStatus;

        var taskForm = new TaskForm("taskForm", null, propertyService.fetchAllProperties(), userService.fetchAllUsers(), onSubmitListener);
        var taskList = new TaskList("taskList", Model.ofList(taskService.fetchAllTasks()), onStatusChangeListener);

        add(taskForm);
        add(taskList);
    }

}
