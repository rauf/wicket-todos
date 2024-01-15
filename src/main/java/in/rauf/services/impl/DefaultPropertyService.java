package in.rauf.services.impl;

import in.rauf.dao.PropertyDao;
import in.rauf.models.Property;
import in.rauf.services.PropertyService;

import java.io.Serializable;
import java.util.List;

public class DefaultPropertyService implements PropertyService, Serializable {
    private final PropertyDao propertyDao;

    public DefaultPropertyService(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }

    @Override
    public List<Property> fetchAllProperties() {
        var propertyEntities = propertyDao.findAll();

        return propertyEntities.stream()
                .map(pe -> new Property(pe.getId(), pe.getName()))
                .toList();
    }

}
