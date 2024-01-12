//package in.rauf.components.taskpanel;
//
//
//import in.rauf.models.Task;
//import in.rauf.models.TaskStatus;
//import org.apache.wicket.behavior.AttributeAppender;
//import org.apache.wicket.markup.html.basic.Label;
//import org.apache.wicket.markup.html.panel.Panel;
//import org.apache.wicket.model.IModel;
//
//public class TaskPanel extends Panel {
//
//
//    public TaskPanel(String id, IModel<Task> model) {
//        super(id, model);
//
//        var task = model.getObject();
//
//        item.add(new Label("taskId", task.getId().toString()));
//        item.add(new Label("taskName", task.getName()));
//
//        if (task.getStatus().equals(TaskStatus.COMPLETED)) {
//            item.add(new Label("taskStatus", task.getStatus().toString()).add(new AttributeAppender("class", "text-success")));
//        } else {
//            item.add(new Label("taskStatus", task.getStatus().toString()).add(new AttributeAppender("class", "text-danger")));
//        }
//
//        if (task.getPriority() != null) {
//            item.add(new Label("taskPriority", task.getPriority().toString()));
//        } else {
//            item.add(new Label("taskPriority", "Not Assigned"));
//        }
//
//        if (task.getAssignedToUserId() != null) {
//            item.add(new Label("taskAssignedTo", task.getAssignedToUserId().toString()));
//        } else {
//            item.add(new Label("taskAssignedTo", "Not Assigned"));
//        }
//
//        if (task.getDueDate() != null) {
//            item.add(new Label("taskDueDate", task.getDueDate().toString()));
//        } else {
//            item.add(new Label("taskDueDate", "Not Assigned"));
//        }
//
//        if (task.getBuildingId() != null) {
//            item.add(new Label("taskBuilding", task.getBuildingId().toString()));
//        } else {
//            item.add(new Label("taskBuilding", "Not Assigned"));
//        }
//        if (task.getCreatedAt() != null) {
//            item.add(new Label("taskCreatedAt", task.getCreatedAt().toString()));
//        } else {
//            item.add(new Label("taskCreatedAt", "Not Assigned"));
//        }
//        if (task.getUpdatedAt() != null) {
//
//            item.add(new Label("taskUpdatedAt", task.getUpdatedAt().toString()));
//        } else {
//            item.add(new Label("taskUpdatedAt", "Not Assigned"));
//        }
//
//    }
//}
