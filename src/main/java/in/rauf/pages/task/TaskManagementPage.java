package in.rauf.pages.task;

import in.rauf.components.taskfilter.TaskFilter;
import in.rauf.components.taskfilter.TaskFilters;
import in.rauf.components.taskform.OnButtonClickListener;
import in.rauf.components.taskform.TaskForm;
import in.rauf.components.tasklist.OnStatusChangeListener;
import in.rauf.components.tasklist.TaskList;
import in.rauf.dao.PropertyDao;
import in.rauf.dao.TaskDao;
import in.rauf.dao.UserDao;
import in.rauf.layouts.main.MainLayout;
import in.rauf.models.Property;
import in.rauf.models.Task;
import in.rauf.models.User;
import in.rauf.services.PropertyService;
import in.rauf.services.TaskService;
import in.rauf.services.UserService;
import in.rauf.utils.NumberUtils;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.List;

import static in.rauf.components.taskfilter.TaskFilter.FILTER_PROPERTY_ID;
import static in.rauf.components.taskfilter.TaskFilter.FILTER_USER_ID;

public class TaskManagementPage extends MainLayout implements Serializable {

    public static final String ID_TASK_FORM = "taskForm";
    public static final String ID_TASK_LIST = "taskList";
    public static final String ID_TASK_FILTERS = "taskFilters";


    private final TaskService taskService;
    private final PropertyService propertyService;
    private final UserService userService;

    public TaskManagementPage(PageParameters parameters) {
        super(parameters);
        propertyService = new PropertyService(new PropertyDao());
        userService = new UserService(new UserDao());
        taskService = new TaskService(new TaskDao());

        OnButtonClickListener<Task> onSubmitListener = taskService::save;
        OnButtonClickListener<Task> onDeleteListener = t -> taskService.delete(t.getId());
        OnStatusChangeListener onStatusChangeListener = taskService::updateStatus;

        var allUsers = userService.fetchAllUsers();
        var allProperties = propertyService.fetchAllProperties();

        var filters = getCurrentFilterData(parameters, allUsers, allProperties);

        var filteredTasks = taskService.fetchAllTasksForFilters(filters);

        var taskForm = new TaskForm(ID_TASK_FORM, null, allProperties, allUsers, onSubmitListener);
        var taskList = new TaskList(ID_TASK_LIST, Model.ofList(filteredTasks), onStatusChangeListener, onDeleteListener);
        var taskFilters = new TaskFilter(ID_TASK_FILTERS, filters, allUsers, allProperties);

        add(taskForm);
        add(taskList);
        add(taskFilters);
    }

    public TaskFilters getCurrentFilterData(PageParameters parameters, List<User> userList, List<Property> propertyList) {
        var userId = NumberUtils.parse(parameters.get(FILTER_USER_ID).toString());
        var propertyId = NumberUtils.parse(parameters.get(FILTER_PROPERTY_ID).toString());

        var user = userList.stream().filter(u -> u.id().equals(userId)).findFirst().orElse(null);
        var property = propertyList.stream().filter(p -> p.id().equals(propertyId)).findFirst().orElse(null);
        return new TaskFilters(user, property);
    }


}
