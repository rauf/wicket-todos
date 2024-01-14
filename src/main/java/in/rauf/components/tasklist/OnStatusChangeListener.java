package in.rauf.components.tasklist;

import in.rauf.models.TaskStatus;

import java.io.Serializable;

public interface OnStatusChangeListener extends Serializable {
    void onStatusChange(Long id, TaskStatus taskStatus);
}
