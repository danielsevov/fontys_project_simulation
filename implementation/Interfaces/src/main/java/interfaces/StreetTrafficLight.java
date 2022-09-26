package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface StreetTrafficLight extends TrafficLight{

    /**
     * Changes state of the traffic light
     *
     * @param state to which the change is transitioning
     *
     */
    void changeState(StreetLightState state);

    /**
     * Get StreetShape
     * @return StreetShape
     */
    StreetShape getShape();

    /**
     * Sets StreetShape
     * @param newShape shape to change to
     */
    void setShape(StreetShape newShape);

}
