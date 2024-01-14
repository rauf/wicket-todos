package in.rauf.components.taskform;

import in.rauf.components.taskform.render.PropertyChoiceRenderer;
import in.rauf.components.taskform.render.UserChoiceRenderer;
import in.rauf.models.Property;
import in.rauf.models.Task;
import in.rauf.models.TaskPriority;
import in.rauf.models.User;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
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

    public static final String ID_TASK_FORM = "taskForm";
    public static final String ID_TITLE = "name";
    public static final String ID_PRIORITY_DROPDOWN = "priority";
    public static final String ID_PROPERTY_DROPDOWN = "property";
    public static final String ID_USER_DROPDOWN = "assignedTo";
    public static final String ID_ACTION_BUTTON = "actionButton";
    public static final String ID_DUE_DATE = "dueDate";

    private Task task;

    public TaskForm(String id, Task t, List<Property> propertyList, List<User> userList, OnButtonClickListener<Task> onSubmitListener) {
        super(id);
        this.task = t != null ? t : new Task();

        Form<Task> taskForm = new Form<>(ID_TASK_FORM, new CompoundPropertyModel<>(this.task));

        taskForm.add(new RequiredTextField<>(ID_TITLE));
        taskForm.add(new DateTextField(ID_DUE_DATE, "yyyy-MM-dd"));
        taskForm.add(new DropDownChoice<>(ID_PRIORITY_DROPDOWN, Arrays.asList(TaskPriority.values())));

        var propertyDropDown = new DropDownChoice<>(ID_PROPERTY_DROPDOWN, propertyList, new PropertyChoiceRenderer());
        var userDropDown = new DropDownChoice<>(ID_USER_DROPDOWN, userList, new UserChoiceRenderer());

        taskForm.add(userDropDown);
        taskForm.add(propertyDropDown);

        taskForm.add(new Button(ID_ACTION_BUTTON) {
            @Override
            public void onSubmit() {
                onSubmitListener.onClick(task);
                setResponsePage(getPage().getClass());
            }
        });

        add(taskForm);
    }
}
