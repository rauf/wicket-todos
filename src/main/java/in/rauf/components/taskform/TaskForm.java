package in.rauf.components.taskform;

import in.rauf.components.taskform.render.PropertyChoiceRenderer;
import in.rauf.components.taskform.render.UserChoiceRenderer;
import in.rauf.models.Property;
import in.rauf.models.Task;
import in.rauf.models.TaskPriority;
import in.rauf.models.User;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TaskForm extends Panel implements Serializable {

    public static final String FIELD_TITLE = "name";
    public static final String PRIORITY_DROPDOWN = "priority";
    public static final String PROPERTY_DROPDOWN = "property";
    public static final String USER_DROPDOWN = "assignedTo";

    private Task task;

    public TaskForm(String id, Task t, List<Property> propertyList, List<User> userList, OnSubmitListener<Task> onSubmitListener) {
        super(id);
        this.task = t != null ? t : new Task();

        Form<Task> taskForm = new Form<>("taskForm", new CompoundPropertyModel<>(this.task));

        taskForm.add(new RequiredTextField<>(FIELD_TITLE));
//        taskForm.add(new DateTextField("dueDate"));
        taskForm.add(new DropDownChoice<>(PRIORITY_DROPDOWN, Arrays.asList(TaskPriority.values())));

        var propertyDropDown = new DropDownChoice<>(PROPERTY_DROPDOWN, propertyList, new PropertyChoiceRenderer());
        var userDropDown = new DropDownChoice<>(USER_DROPDOWN, userList, new UserChoiceRenderer());

        taskForm.add(userDropDown);
        taskForm.add(propertyDropDown);

        taskForm.add(new Button("actionButton") {
            @Override
            public void onSubmit() {
                System.out.println("Property: " + task.getProperty());
                onSubmitListener.onSubmit(task);
                setResponsePage(getPage().getClass()); // Refresh the page or navigate to another page
            }
        });

        add(taskForm);
    }
}
