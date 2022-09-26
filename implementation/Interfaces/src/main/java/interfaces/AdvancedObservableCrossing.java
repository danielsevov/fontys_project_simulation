package interfaces;

/**
 * Advanced crossings are supplied with 2 pedestrian and 12 street traffic lights
 * (3 street lights for the 3 directions per each of the 4 sides).
 *
 */
public interface AdvancedObservableCrossing extends Crossing{
    void addHorizontalPedestrianLightObserver(LightObserver observer);

    void addVerticalPedestrianLightObserver(LightObserver observer);

    void addHorizontalLeftStreetLightObserver(LightObserver observer);

    void addVerticalLeftStreetLightObserver(LightObserver observer);

    void addHorizontalRightStreetLightObserver(LightObserver observer);

    void addVerticalRightStreetLightObserver(LightObserver observer);

    void addHorizontalStraightStreetLightObserver(LightObserver observer);

    void addVerticalStraightStreetLightObserver(LightObserver observer);
}
