package in.rauf.mappers;

import in.rauf.entities.PropertyEntity;
import in.rauf.models.Property;

public class PropertyMapper {

    public static Property mapEntity(PropertyEntity propertyEntity) {
        return new Property(propertyEntity.getId(), propertyEntity.getName());
    }

    public static PropertyEntity mapModel(Property property) {
        var propertyEntity = new PropertyEntity();
        propertyEntity.setId(property.id());
        propertyEntity.setName(property.name());
        return propertyEntity;
    }
}
