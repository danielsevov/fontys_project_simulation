package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface TrafficLight extends ObservableTrafficLight {
    /**
     * Used to loop through all passing states
     *
     */
    void stopTraffic();

    /**
     * Used to loop through all non-passing states
     *
     */
    void startTraffic();

    /**
     * Change to next state
     */
    void changeToNextState();

    /**
     * Returns current state
     *
     */
    LightState getCurrentState();


    /**
     * Getter for name of trafficLight
     *
     */
    String getName();

}
