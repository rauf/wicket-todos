package in.rauf.components.taskform.render;

import in.rauf.models.User;
import org.apache.wicket.markup.html.form.IChoiceRenderer;

public class UserChoiceRenderer implements IChoiceRenderer<User> {
    @Override
    public Object getDisplayValue(User user) {
        return user.name();
    }

    @Override
    public String getIdValue(User user, int index) {
        return user.id().toString();
    }
}
