package d.generic;

import java.io.Serializable;

public class CastingDTO <T> implements Serializable {
    private T object;

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

}