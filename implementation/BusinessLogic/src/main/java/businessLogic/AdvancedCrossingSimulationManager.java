package businessLogic;

import interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedCrossingSimulationManager implements interfaces.AdvancedCrossingSimulationManager {
    private final TrafficLightFactory trafficLightFactory;
    private final CrossingModeFactory crossingModeFactory;

    private final AdvancedObservableCrossing advancedObservableCrossing;
    private final Map<String, CrossingMode> stringCrossingModeMap;

    public AdvancedCrossingSimulationManager(TrafficLightFactory trafficLightFactory, CrossingModeFactory crossingModeFactory) {
        this.trafficLightFactory = trafficLightFactory;
        this.crossingModeFactory = crossingModeFactory;
        advancedObservableCrossing = createAdvancedObservableCrossing();

        this.stringCrossingModeMap = new HashMap<>();

        stringCrossingModeMap.put("Simple Crossing Mode", crossingModeFactory.createSimpleCrossingMode());
        stringCrossingModeMap.put("German Crossing Mode", crossingModeFactory.createGermanCrossingMode());
        stringCrossingModeMap.put("Emergency Crossing Mode", crossingModeFactory.createEmergencyCrossingMode());
        stringCrossingModeMap.put("Dutch Crossing Mode", crossingModeFactory.createDutchCrossingMode());
        stringCrossingModeMap.put("Bulgarian Crossing Mode", crossingModeFactory.createBulgarianCrossingMode());
    }

    private AdvancedObservableCrossing createAdvancedObservableCrossing() {
        PedestrianTrafficLight horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        PedestrianTrafficLight verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        StreetTrafficLight horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal straight");
        StreetTrafficLight verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical straight");
        StreetTrafficLight horL = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal left");
        StreetTrafficLight verL = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical left");
        StreetTrafficLight horR = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal right");
        StreetTrafficLight verR = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical right");

        CrossingMode germanCrossingMode = crossingModeFactory.createGermanCrossingMode();

        AdvancedObservableCrossing newCrossing = new crossings.AdvancedObservableCrossing(germanCrossingMode, horPed, verPed, horStr, verStr);

        newCrossing.addHorizontalLeft(horL);
        newCrossing.addVerticalLeft(verL);
        newCrossing.addHorizontalRight(horR);
        newCrossing.addVerticalRight(verR);

        return newCrossing;
    }

    @Override
    public void activateAdvancedCrossing(int length) {
        advancedObservableCrossing.activate(length);
    }

    @Override
    public void deactivateAdvancedCrossing() {
        advancedObservableCrossing.deactivate();
    }

    @Override
    public void addObserversToAdvancedCrossing(List<LightObserver> horizontalPedestrian, List<LightObserver> verticalPedestrian,
                                               List<LightObserver> horizontalStreetStraight, List<LightObserver> verticalStreetStraight,
                                               List<LightObserver> horizontalStreetLeft, List<LightObserver> verticalStreetLeft,
                                               List<LightObserver> horizontalStreetRight, List<LightObserver> verticalStreetRight) {
        horizontalPedestrian.forEach(advancedObservableCrossing::addHorizontalPedestrianLightObserver);
        verticalPedestrian.forEach(advancedObservableCrossing::addVerticalPedestrianLightObserver);
        horizontalStreetStraight.forEach(advancedObservableCrossing::addHorizontalStraightStreetLightObserver);
        verticalStreetStraight.forEach(advancedObservableCrossing::addVerticalStraightStreetLightObserver);
        horizontalStreetLeft.forEach(advancedObservableCrossing::addHorizontalLeftStreetLightObserver);
        verticalStreetLeft.forEach(advancedObservableCrossing::addVerticalLeftStreetLightObserver);
        horizontalStreetRight.forEach(advancedObservableCrossing::addHorizontalRightStreetLightObserver);
        verticalStreetRight.forEach(advancedObservableCrossing::addVerticalRightStreetLightObserver);
    }

    @Override
    public void setAdvancedCrossingMode(String mode) {
        advancedObservableCrossing.setMode(stringCrossingModeMap.get(mode));
    }


    @Override
    public List<String> getAllCrossingModesStrings(){
        return new ArrayList<>(stringCrossingModeMap.keySet());
    }


}
