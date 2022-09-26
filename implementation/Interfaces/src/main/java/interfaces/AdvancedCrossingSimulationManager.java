package interfaces;

import java.util.List;

public interface AdvancedCrossingSimulationManager {
    void activateAdvancedCrossing(int length);

    void deactivateAdvancedCrossing();

    void addObserversToAdvancedCrossing(List<LightObserver> horizontalPedestrian, List<LightObserver> verticalPedestrian,
                                        List<LightObserver> horizontalStreetStraight, List<LightObserver> verticalStreetStraight,
                                        List<LightObserver> horizontalStreetLeft, List<LightObserver> verticalStreetLeft,
                                        List<LightObserver> horizontalStreetRight, List<LightObserver> verticalStreetRight);

    List<String> getAllCrossingModesStrings();

    void setAdvancedCrossingMode(String mode);
}
