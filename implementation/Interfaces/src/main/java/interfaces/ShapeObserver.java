package interfaces;


/**
 * Observer used to update JavaFX elements based on the traffic light shape
 */
public interface ShapeObserver {
    void update(Shape newShape);
}
