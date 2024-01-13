package in.rauf.components.tasklist;

import in.rauf.models.Task;
import in.rauf.models.TaskPriority;
import in.rauf.models.TaskStatus;
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

    public TaskList(String id, IModel<List<Task>> taskListModel) {
        super(id, taskListModel);
        add(getTaskListView(taskListModel));
    }

    private static ListView<Task> getTaskListView(IModel<List<Task>> taskListModel) {
        return new ListView<>("taskList", taskListModel) {
            @Override
            protected void populateItem(ListItem<Task> item) {
                var task = item.getModelObject();

                var assignedTo = task.getUser() != null ? task.getUser() : NOT_ASSIGNED;
                var dueDate = task.getDueDate() != null ? task.getDueDate().toString() : NOT_ASSIGNED;
                var buildingId = task.getProperty() != null ? task.getProperty().toString() : NOT_ASSIGNED;

//                item.add(new Label("taskId", task.getId().toString()));
                item.add(new Label("taskName", task.getName()));
                item.add(getStatusComponent(task));
                item.add(getPriorityComponent(task));
                item.add(new Label("taskAssignedTo", assignedTo));
                item.add(new Label("taskDueDate", dueDate));
                item.add(new Label("taskBuilding", buildingId));
            }
        };
    }

    static Component getStatusComponent(Task task) {
        var status = task.getStatus() != null ? task.getStatus() : NOT_ASSIGNED;
        if (status.equals(TaskStatus.COMPLETED)) {
            return new Label("taskStatus", status.toString()).add(new AttributeAppender("class", "badge text-bg-success"));
        } else {
            return new Label("taskStatus", status.toString()).add(new AttributeAppender("class", "badge text-bg-light"));
        }
    }

    static Component getPriorityComponent(Task task) {
        var priority = task.getPriority() != null ? task.getPriority() : NOT_ASSIGNED;
        if (priority.equals(TaskPriority.HIGH)) {
            return new Label("taskPriority", priority.toString()).add(new AttributeAppender("class", "badge text-bg-warning"));
        } else if (priority.equals(TaskPriority.MEDIUM)) {
            return new Label("taskPriority", priority.toString()).add(new AttributeAppender("class", "badge text-bg-primary"));
        } else if (priority.equals(TaskPriority.LOW)) {
            return new Label("taskPriority", priority.toString()).add(new AttributeAppender("class", "badge text-bg-secondary"));
        } else {
            return new Label("taskPriority", priority);
        }
    }

}
