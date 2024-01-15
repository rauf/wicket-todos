package in.rauf.services;

import in.rauf.models.Property;

import java.io.Serializable;
import java.util.List;

public interface PropertyService extends Serializable {

    List<Property> fetchAllProperties();
}
