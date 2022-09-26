package interfaces;

import java.util.List;

public interface StreetTrafficLightSimulationManager {
    List<String> getAllStreetLightBehaviourStrings();

    List<String> getAllStreetShapesStrings();

    void setShapeOfStreetTrafficLight(String shape);

    void setLightBehaviourOfStreetTrafficLight(String behaviour);

    void addObserversToStreetTrafficLight(LightObserver lightObserver, ShapeObserver shapeObserver);

    String getNameOfCurrentStateOfStreetTrafficLight();

    void changeStateToNextForStreetTrafficLight();


}
