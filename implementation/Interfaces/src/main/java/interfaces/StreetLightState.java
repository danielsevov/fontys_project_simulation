package interfaces;

/**
 * Interface for PedestrianLightState
 *
 */
public interface StreetLightState extends LightState {
    /**
     * Getter for the next state
     *
     */
    StreetLightState getNext();

    /**
     * Used to change the state of the traffic light
     *
     * @param light traffic light to change the state of
     *
     */
    default void changeState(StreetTrafficLight light) {
        System.out.println("Changing from " + light.getCurrentState() + " -> " + getNext() + " for " + light.getName() + " traffic light ( " + light.getShape() + " )");
        light.changeState(getNext());
        light.informForLightChange();
    }
}
