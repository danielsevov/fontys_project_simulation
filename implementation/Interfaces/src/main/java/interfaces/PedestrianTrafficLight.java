package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface PedestrianTrafficLight extends TrafficLight{

    /**
     * Changes state of the traffic light
     *
     * @param state to which the change is transitioning
     *
     */
    void changeState(PedestrianLightState state);

    /**
     * Get Pedestrian Shape
     * @return Pedestrian shape
     */
    PedestrianShape getShape();

    /**
     * Set pedestrian shape
     * @param newShape to change
     */
    void setShape(PedestrianShape newShape);

}
