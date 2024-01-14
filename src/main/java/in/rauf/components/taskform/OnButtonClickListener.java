package in.rauf.components.taskform;

import java.io.Serializable;

public interface OnButtonClickListener<T> extends Serializable {
    void onClick(T data);
}
