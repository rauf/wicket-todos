package in.rauf.services;

import in.rauf.dao.PropertyDao;
import in.rauf.models.Property;

import java.util.List;

public class PropertyService {

    private final PropertyDao propertyDao;

    public PropertyService(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }

    public List<Property> fetchAllProperties() {
        var propertyEntities = propertyDao.findAll();

        return propertyEntities.stream()
                .map(pe -> new Property(pe.getId(), pe.getName()))
                .toList();
    }
}
