package businessLogic;

import interfaces.*;
import shapes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreetTrafficLightSimulationManager implements interfaces.StreetTrafficLightSimulationManager {
    private final TrafficLightFactory trafficLightFactory;
    private final StreetTrafficLight streetTrafficLight;
    private final Map<String, StreetShape> streetStringToShapeMap;
    private final Map<String, StreetLightState> streetLightStateMap;


    public StreetTrafficLightSimulationManager(TrafficLightFactory trafficLightFactory) {
        this.trafficLightFactory = trafficLightFactory;
        streetTrafficLight = trafficLightFactory.createGermanStreetTrafficLight("street traffic light");

        this.streetLightStateMap = new HashMap<>();
        this.streetStringToShapeMap = new HashMap<>();

        streetStringToShapeMap.put("Arrow Forward Shape", new ArrowForwardShape());
        streetStringToShapeMap.put("Arrow Left Shape", new ArrowLeftShape());
        streetStringToShapeMap.put("Arrow Right Shape", new ArrowRightShape());

        LightBehaviourFactory lightBehaviourFactory = trafficLightFactory.getLightBehaviourFactory();
        streetLightStateMap.put("German Street Behaviour", lightBehaviourFactory.getInitialGermanStreetState());
        streetLightStateMap.put("Dutch Street Behaviour", lightBehaviourFactory.getInitialDutchStreetState());
        streetLightStateMap.put("Bulgarian Street Behaviour", lightBehaviourFactory.getInitialBulgarianStreetState());
    }

    @Override
    public List<String> getAllStreetLightBehaviourStrings() {
        return new ArrayList<>(streetLightStateMap.keySet());
    }

    @Override
    public List<String> getAllStreetShapesStrings() {
        return new ArrayList<>(streetStringToShapeMap.keySet());
    }

    @Override
    public void setShapeOfStreetTrafficLight(String shape) {
        streetTrafficLight.setShape(streetStringToShapeMap.get(shape));
    }

    @Override
    public void setLightBehaviourOfStreetTrafficLight(String behaviour) {
        streetTrafficLight.changeState(streetLightStateMap.get(behaviour));
    }

    @Override
    public void addObserversToStreetTrafficLight(LightObserver lightObserver, ShapeObserver shapeObserver) {
        streetTrafficLight.addLightObserver(lightObserver);
        streetTrafficLight.addShapeObserver(shapeObserver);
    }

    @Override
    public String getNameOfCurrentStateOfStreetTrafficLight() {
        return streetTrafficLight.getCurrentState().getName();
    }

    @Override
    public void changeStateToNextForStreetTrafficLight() {
        streetTrafficLight.changeToNextState();
    }
}
