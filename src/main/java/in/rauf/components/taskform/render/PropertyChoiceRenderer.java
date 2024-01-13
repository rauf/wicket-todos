package in.rauf.components.taskform.render;

import in.rauf.models.Property;
import org.apache.wicket.markup.html.form.IChoiceRenderer;

public class PropertyChoiceRenderer implements IChoiceRenderer<Property> {
    @Override
    public Object getDisplayValue(Property object) {
        return object.name();
    }

    @Override
    public String getIdValue(Property object, int index) {
        return object.id().toString();
    }
}
