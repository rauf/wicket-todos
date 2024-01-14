package in.rauf.components.status;

import in.rauf.models.Task;
import in.rauf.models.TaskStatus;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatusProgressComponent extends Panel {

    public static final String ID_COMPLETED = "completed";
    public static final String ID_TODO = "todo";
    public static final String ID_IN_PROGRESS = "inProgress";
    public static final String ID_HOLD = "hold";

    public StatusProgressComponent(String id, List<Task> taskList) {
        super(id);


        var taskProgressPercentages = getTaskProgressPercentagePerStatus(taskList);

        add(getTaskProgressComponent(ID_COMPLETED, TaskStatus.COMPLETED, taskProgressPercentages));
        add(getTaskProgressComponent(ID_TODO, TaskStatus.TODO, taskProgressPercentages));
        add(getTaskProgressComponent(ID_IN_PROGRESS, TaskStatus.IN_PROGRESS, taskProgressPercentages));
        add(getTaskProgressComponent(ID_HOLD, TaskStatus.ON_HOLD, taskProgressPercentages));
    }


    private Component getTaskProgressComponent(String id, TaskStatus status, Map<TaskStatus, Double> taskProgressPercentages) {
        var field = new Label(id);
        var percentWidth = taskProgressPercentages.getOrDefault(status, 0.0);
        field.add(AttributeModifier.append("style", "width:" + percentWidth + "%"));
        field.setDefaultModel(Model.of(status.name()));
        return field;
    }


    public Map<TaskStatus, Double> getTaskProgressPercentagePerStatus(List<Task> taskList) {
        var totalTasks = taskList.size();

        return taskList.stream().collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()))
                .entrySet().stream().collect(
                        Collectors.toMap(Map.Entry::getKey, e -> (double) e.getValue() / totalTasks * 100)
                );
    }
}
