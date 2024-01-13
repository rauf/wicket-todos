package in.rauf.components.taskform.render;

import in.rauf.models.User;
import org.apache.wicket.markup.html.form.IChoiceRenderer;

public class UserChoiceRenderer implements IChoiceRenderer<User> {
    @Override
    public Object getDisplayValue(User object) {
        return object.name();
    }

    @Override
    public String getIdValue(User object, int index) {
        return object.id().toString();
    }
}
