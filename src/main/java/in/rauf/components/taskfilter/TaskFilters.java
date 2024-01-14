package in.rauf.components.taskfilter;

import in.rauf.models.Property;
import in.rauf.models.User;

public class TaskFilters {
    private User user;
    private Property property;

    public TaskFilters(User user, Property property) {
        this.user = user;
        this.property = property;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}