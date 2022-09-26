package interfaces;


/**
 * Makes the traffic light observable so that the JavaFX elements cn observe the light states and shapes
 */
public interface ObservableTrafficLight {
    void addLightObserver(LightObserver o);

    void removeLightObserver(LightObserver o);

    void informForLightChange();

    void addShapeObserver(ShapeObserver o);

    void informForShapeChange(Shape shape);
}


