package interfaces;

import java.util.List;

public interface BasicCrossingSimulationManager {
    void activateBasicCrossing(int length);

    void deactivateBasicCrossing();

    void addObserversToBasicCrossing(List<LightObserver> horizontalPedestrian, List<LightObserver> verticalPedestrian,
                                     List<LightObserver> horizontalStreet, List<LightObserver> verticalStreet);

}
