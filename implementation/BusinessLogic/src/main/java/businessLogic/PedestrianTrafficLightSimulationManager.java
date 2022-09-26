package businessLogic;

import interfaces.*;
import shapes.DonkeyShape;
import shapes.DotShape;
import shapes.ManShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedestrianTrafficLightSimulationManager implements interfaces.PedestrianTrafficLightSimulationManager {
    private final TrafficLightFactory trafficLightFactory;
    private final PedestrianTrafficLight pedestrianTrafficLight;
    private final Map<String, PedestrianShape> pedestrianStringToShapeMap;
    private final Map<String, PedestrianLightState> pedestrianLightStateMap;


    public PedestrianTrafficLightSimulationManager(TrafficLightFactory trafficLightFactory) {
        this.trafficLightFactory = trafficLightFactory;
        this.pedestrianTrafficLight = trafficLightFactory.createGermanPedestrianTrafficLight("pedestrian traffic light");
        this.pedestrianStringToShapeMap = new HashMap<>();
        this.pedestrianLightStateMap = new HashMap<>();

        pedestrianStringToShapeMap.put("Dot Shape", new DotShape());
        pedestrianStringToShapeMap.put("Man Shape", new ManShape());
        pedestrianStringToShapeMap.put("Donkey Shape", new DonkeyShape());

        LightBehaviourFactory lightBehaviourFactory = trafficLightFactory.getLightBehaviourFactory();
        pedestrianLightStateMap.put("German Pedestrian Behaviour", lightBehaviourFactory.getInitialGermanPedestrianState());
        pedestrianLightStateMap.put("Dutch Pedestrian Behaviour", lightBehaviourFactory.getInitialDutchPedestrianState());
        pedestrianLightStateMap.put("Australian Pedestrian Behaviour", lightBehaviourFactory.getInitialAustralianPedestrianState());
        pedestrianLightStateMap.put("Bulgarian Pedestrian Behaviour", lightBehaviourFactory.getInitialBulgarianPedestrianState());
    }

    @Override
    public List<String> getAllPedestrianShapesStrings(){
        return new ArrayList<>(pedestrianStringToShapeMap.keySet());
    }

    @Override
    public List<String> getAllPedestrianLightBehaviourStrings(){
        return new ArrayList<>(pedestrianLightStateMap.keySet());
    }

    @Override
    public void setShapeOfPedestrianTrafficLight(String shape) {
        pedestrianTrafficLight.setShape(pedestrianStringToShapeMap.get(shape));
    }

    @Override
    public void setLightBehaviourOfPedestrianTrafficLight(String behaviour) {
        pedestrianTrafficLight.changeState(pedestrianLightStateMap.get(behaviour));
    }

    @Override
    public void addObserversToPedestrianTrafficLight(LightObserver lightObserver, ShapeObserver shapeObserver) {
        pedestrianTrafficLight.addLightObserver(lightObserver);
        pedestrianTrafficLight.addShapeObserver(shapeObserver);
    }

    @Override
    public String getNameOfCurrentStateOfPedestrianTrafficLight() {
        return pedestrianTrafficLight.getCurrentState().getName();
    }

    @Override
    public void changeStateToNextForPedestrianTrafficLight() {
        pedestrianTrafficLight.changeToNextState();
    }

}
