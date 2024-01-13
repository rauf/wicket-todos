package in.rauf.components.tasklist;

import in.rauf.models.Task;
import in.rauf.utils.DateUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.io.Serializable;
import java.util.List;

public class TaskList extends Panel implements Serializable {

    public static final String NOT_ASSIGNED = "-";
    public static final String TASK_PRIORITY = "taskPriority";
    public static final String TASK_STATUS = "taskStatus";
    public static final String TASK_ASSIGNED_TO = "taskAssignedTo";
    public static final String TASK_PROPERTY = "taskProperty";
    public static final String TASK_DUE_DATE = "taskDueDate";
    public static final String TASK_NAME = "taskName";

    public TaskList(String id, IModel<List<Task>> taskListModel) {
        super(id, taskListModel);
        add(getTaskListView(taskListModel));
    }

    private static ListView<Task> getTaskListView(IModel<List<Task>> taskListModel) {
        return new ListView<>("taskList", taskListModel) {
            @Override
            protected void populateItem(ListItem<Task> item) {
                var task = item.getModelObject();

//                item.add(new Label("taskId", task.getId().toString()));
                item.add(new Label(TASK_NAME, task.getName()));
                item.add(getStatusComponent(task));
                item.add(getPriorityComponent(task));
                item.add(getTaskAssignedToComponent(task));
                item.add(getDateComponent(task));
                item.add(getTaskPropertyComponent(task));
            }
        };
    }

    static Component getPriorityComponent(Task task) {
        if (task.getProperty() == null) {
            return new Label(TASK_PRIORITY, NOT_ASSIGNED);
        }
        var priorityCssClasses = switch (task.getPriority()) {
            case HIGH -> "badge text-bg-warning";
            case MEDIUM -> "badge text-bg-primary";
            case LOW -> "badge text-bg-secondary";
        };
        return new Label(TASK_PRIORITY, task.getPriority().toString())
                .add(new AttributeAppender("class", priorityCssClasses));
    }


    static Component getStatusComponent(Task task) {
        if (task.getStatus() == null) {
            return new Label(TASK_STATUS, NOT_ASSIGNED);
        }

        var statusCssClasses = switch (task.getStatus()) {
            case COMPLETED -> "badge text-bg-success";
            default -> "badge text-bg-secondary";
        };

        return new Label(TASK_STATUS, task.getStatus().toString())
                .add(new AttributeAppender("class", statusCssClasses));
    }

    static Component getTaskAssignedToComponent(Task task) {
        var assignedTo = task.getAssignedTo() != null ? task.getAssignedTo().name() : NOT_ASSIGNED;
        return new Label(TASK_ASSIGNED_TO, assignedTo);
    }

    static Component getTaskPropertyComponent(Task task) {
        var property = task.getProperty() != null ? task.getProperty().name() : NOT_ASSIGNED;
        return new Label(TASK_PROPERTY, property);
    }

    static Component getDateComponent(Task task) {
        var dueDate = task.getDueDate() != null ? DateUtils.formatDate(task.getDueDate()) : NOT_ASSIGNED;
        return new Label(TASK_DUE_DATE, dueDate);
    }

}
