package in.rauf.components.taskform.render;

import in.rauf.models.Property;
import org.apache.wicket.markup.html.form.IChoiceRenderer;

public class PropertyChoiceRenderer implements IChoiceRenderer<Property> {
    @Override
    public Object getDisplayValue(Property property) {
        return property.name();
    }

    @Override
    public String getIdValue(Property property, int index) {
        return property.id().toString();
    }
}
