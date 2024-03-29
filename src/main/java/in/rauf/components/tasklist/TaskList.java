package in.rauf.components.tasklist;

import in.rauf.components.taskform.OnButtonClickListener;
import in.rauf.models.Task;
import in.rauf.models.TaskStatus;
import in.rauf.utils.DateUtils;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TaskList extends Panel implements Serializable {

    public static final String NOT_ASSIGNED = "-";
    public static final String ID_TASK_PRIORITY = "priority";
    public static final String ID_TASK_ASSIGNED_TO = "assignedTo";
    public static final String ID_TASK_PROPERTY = "property";
    public static final String ID_TASK_DUE_DATE = "dueDate";
    public static final String ID_TASK_NAME = "name";
    public static final String ID_STATUS_DROPDOWN = "statusDropdown";
    public static final String EVENT_CHANGE = "change";
    public static final String DELETE_BUTTON = "deleteButton";
    public static final String ID_TASK_LIST = "taskList";
    public static final String EVENT_CLICK = "click";

    public TaskList(String id, IModel<List<Task>> taskListModel, OnStatusChangeListener onStatusChangeListener, OnButtonClickListener<Task> onDeleteListener) {
        super(id, taskListModel);
        add(getTaskListView(taskListModel, onStatusChangeListener, onDeleteListener));
    }

    private ListView<Task> getTaskListView(IModel<List<Task>> taskListModel, OnStatusChangeListener onStatusChangeListener, OnButtonClickListener<Task> onDeleteListener) {
        return new ListView<>(ID_TASK_LIST, taskListModel) {
            @Override
            protected void populateItem(ListItem<Task> item) {
                var task = item.getModelObject();

                item.add(getLabel(task));
                item.add(getPriorityComponent(task));
                item.add(getTaskAssignedToComponent(task));
                item.add(getDateComponent(task));
                item.add(getTaskPropertyComponent(task));
                item.add(getStatusDropdownComponent(task, onStatusChangeListener));
                item.add(getDeleteButtonComponent(task, onDeleteListener));
            }
        };
    }

    private Component getStatusDropdownComponent(Task task, OnStatusChangeListener onStatusChangeListener) {
        var statusDropdown = new DropDownChoice<>(ID_STATUS_DROPDOWN, Arrays.asList(TaskStatus.values()));
        statusDropdown.setModel(new PropertyModel<>(task, "status"));
        statusDropdown.add(new AjaxFormComponentUpdatingBehavior(EVENT_CHANGE) {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                var selectedValue = statusDropdown.getModelObject();
                if (selectedValue == null) {
                    return;
                }
                onStatusChangeListener.onStatusChange(task.getId(), selectedValue);
                reloadPage();
            }
        });
        return statusDropdown;
    }

    private static Component getPriorityComponent(Task task) {
        if (task.getPriority() == null) {
            return new Label(ID_TASK_PRIORITY, NOT_ASSIGNED);
        }
        var priorityCssClasses = switch (task.getPriority()) {
            case HIGH -> "badge text-bg-warning";
            case MEDIUM -> "badge text-bg-primary";
            case LOW -> "badge text-bg-secondary";
        };
        return new Label(ID_TASK_PRIORITY, task.getPriority().toString())
                .add(new AttributeAppender("class", priorityCssClasses));
    }

    private Component getDeleteButtonComponent(Task task, OnButtonClickListener<Task> onDeleteListener) {
        return new Button(DELETE_BUTTON)
                .add(new AjaxFormComponentUpdatingBehavior(EVENT_CLICK) {
                    @Override
                    protected void onUpdate(AjaxRequestTarget target) {
                        onDeleteListener.onClick(task);
                        reloadPage();
                    }
                });
    }

    private void reloadPage() {
        setResponsePage(getPage().getClass(), getPage().getPageParameters());
    }

    private static Component getTaskAssignedToComponent(Task task) {
        var assignedTo = task.getAssignedTo() != null ? task.getAssignedTo().name() : NOT_ASSIGNED;
        return new Label(ID_TASK_ASSIGNED_TO, assignedTo);
    }

    private static Component getTaskPropertyComponent(Task task) {
        var property = task.getProperty() != null ? task.getProperty().name() : NOT_ASSIGNED;
        return new Label(ID_TASK_PROPERTY, property);
    }

    private static Component getDateComponent(Task task) {
        var dueDate = task.getDueDate() != null ? DateUtils.formatDate(task.getDueDate()) : NOT_ASSIGNED;
        return new Label(ID_TASK_DUE_DATE, dueDate);
    }

    private static Component getLabel(Task task) {
        return new Label(ID_TASK_NAME, task.getName());
    }
}
