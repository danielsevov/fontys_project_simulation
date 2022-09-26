package interfaces;

/**
 * Observer used to update JavaFX elements based on the traffic light state
 */
public interface LightObserver {
    void update(LightState state);
}
