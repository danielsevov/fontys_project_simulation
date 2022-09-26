package interfaces;

import java.util.List;

public interface PedestrianTrafficLightSimulationManager {
    List<String> getAllPedestrianLightBehaviourStrings();

    List<String> getAllPedestrianShapesStrings();

    void setShapeOfPedestrianTrafficLight(String shape);

    void setLightBehaviourOfPedestrianTrafficLight(String behaviour);

    void addObserversToPedestrianTrafficLight(LightObserver lightObserver, ShapeObserver shapeObserver);

    String getNameOfCurrentStateOfPedestrianTrafficLight();

    void changeStateToNextForPedestrianTrafficLight();
}
