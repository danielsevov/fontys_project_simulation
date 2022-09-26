package businessLogic;

import interfaces.*;

import java.util.List;

public class BasicCrossingSimulationManager implements interfaces.BasicCrossingSimulationManager {
    private final TrafficLightFactory trafficLightFactory;
    private final CrossingModeFactory crossingModeFactory;

    private final BasicObservableCrossing basicObservableCrossing;

    public BasicCrossingSimulationManager(TrafficLightFactory trafficLightFactory, CrossingModeFactory crossingModeFactory) {
        this.trafficLightFactory = trafficLightFactory;
        this.crossingModeFactory = crossingModeFactory;
        basicObservableCrossing = createBasicObservableCrossing();
    }

    private BasicObservableCrossing createBasicObservableCrossing(){

        PedestrianTrafficLight horPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : horizontal");
        PedestrianTrafficLight verPed = trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light : vertical");

        StreetTrafficLight horStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : horizontal");
        StreetTrafficLight verStr = trafficLightFactory.createGermanStreetTrafficLight("german street light : vertical");

        CrossingMode simpleCrossingMode = crossingModeFactory.createSimpleCrossingMode();

        return new crossings.BasicObservableCrossing(simpleCrossingMode, horPed, verPed, horStr, verStr);
    }

    @Override
    public void activateBasicCrossing(int length) {
        basicObservableCrossing.activate(length);
    }

    @Override
    public void deactivateBasicCrossing() {
        basicObservableCrossing.deactivate();
    }

    @Override
    public void addObserversToBasicCrossing(List<LightObserver> horizontalPedestrian, List<LightObserver> verticalPedestrian, List<LightObserver> horizontalStreet, List<LightObserver> verticalStreet) {
        horizontalPedestrian.forEach(basicObservableCrossing::addHorizontalPedestrianLightObserver);
        verticalPedestrian.forEach(basicObservableCrossing::addVerticalPedestrianLightObserver);
        horizontalStreet.forEach(basicObservableCrossing::addHorizontalStreetLightObserver);
        verticalStreet.forEach(basicObservableCrossing::addVerticalStreetLightObserver);
    }
}
