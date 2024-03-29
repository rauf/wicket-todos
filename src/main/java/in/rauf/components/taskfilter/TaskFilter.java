package in.rauf.components.taskfilter;

import in.rauf.components.taskform.render.PropertyChoiceRenderer;
import in.rauf.components.taskform.render.UserChoiceRenderer;
import in.rauf.models.Property;
import in.rauf.models.User;
import in.rauf.pages.task.TaskManagementPage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

public class TaskFilter extends Panel {

    public static final String FILTER_USER_ID = "userId";
    public static final String FILTER_PROPERTY_ID = "propertyId";
    public static final String ID_FILTER_FORM = "filterForm";
    public static final String ID_USER = "user";
    public static final String ID_PROPERTY = "property";
    public static final String EVENT_CHANGE = "change";

    private TaskFilters taskFilters;

    public TaskFilter(String id, TaskFilters currentFilters, List<User> userList, List<Property> propertyList) {
        super(id);
        this.taskFilters = currentFilters;

        Form<TaskFilters> taskForm = new Form<>(ID_FILTER_FORM, new CompoundPropertyModel<>(this.taskFilters));

        taskForm.add(getUserDropdownComponent(userList));
        taskForm.add(getPropertyDropdownComponent(propertyList));
        add(taskForm);
    }

    private Component getUserDropdownComponent(List<User> userList) {
        var userDropDown = new DropDownChoice<>(ID_USER, userList, new UserChoiceRenderer());
        userDropDown.add(new AjaxFormComponentUpdatingBehavior(EVENT_CHANGE) {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                setResponsePage(TaskManagementPage.class, preparePageParameters());
            }
        });
        return userDropDown;
    }

    private Component getPropertyDropdownComponent(List<Property> propertyList) {
        var propertyDropDown = new DropDownChoice<>(ID_PROPERTY, propertyList, new PropertyChoiceRenderer());
        propertyDropDown.add(new AjaxFormComponentUpdatingBehavior(EVENT_CHANGE) {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                setResponsePage(TaskManagementPage.class, preparePageParameters());
            }
        });
        return propertyDropDown;
    }

    private PageParameters preparePageParameters() {
        PageParameters parameters = new PageParameters();
        if (taskFilters.getUser() != null) {
            parameters.add(FILTER_USER_ID, taskFilters.getUser().id());
        }
        if (taskFilters.getProperty() != null) {
            parameters.add(FILTER_PROPERTY_ID, taskFilters.getProperty().id());
        }
        return parameters;
    }

}
