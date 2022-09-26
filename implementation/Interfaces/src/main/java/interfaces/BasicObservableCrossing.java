package interfaces;
/**
 * Basic crossings are supplied with only 2 pedestrian and 2 street traffic lights.
 *
 */
public interface BasicObservableCrossing extends Crossing{
    void addHorizontalPedestrianLightObserver(LightObserver observer);

    void addVerticalPedestrianLightObserver(LightObserver observer);

    void addHorizontalStreetLightObserver(LightObserver observer);

    void addVerticalStreetLightObserver(LightObserver observer);
}
