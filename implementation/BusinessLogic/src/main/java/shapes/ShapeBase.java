package shapes;

import interfaces.Shape;
import java.util.Objects;

/**
 * Base class for implementations of the Shape Interface
 *
 */
public abstract class ShapeBase implements Shape {
    private String name;

    public ShapeBase(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name + " Shape";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeBase that = (ShapeBase) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
