package in.rauf.components.taskform;

import java.io.Serializable;

public interface OnSubmitListener<T> extends Serializable {
    void onSubmit(T data);
}
