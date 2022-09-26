package businessLogic;

import factories.SimpleCrossingModeFactory;
import factories.SimpleTrafficLightFactory;
import interfaces.*;
import interfaces.BasicCrossingSimulationManager;
import interfaces.PedestrianTrafficLightSimulationManager;
import interfaces.StreetTrafficLightSimulationManager;
import shapes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hub with access to the business logic layer.
 */
public class BusinessLogicAPIImpl implements BusinessLogicAPI {
    private static final TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();
    private static final CrossingModeFactory crossingModeFactory = new SimpleCrossingModeFactory();

    @Override
    public PedestrianTrafficLightSimulationManager getPedestrianLightSimulationManager() {
        return new businessLogic.PedestrianTrafficLightSimulationManager(trafficLightFactory);
    }

    @Override
    public StreetTrafficLightSimulationManager getStreetLightSimulationManager() {
        return new businessLogic.StreetTrafficLightSimulationManager(trafficLightFactory);
    }

    @Override
    public BasicCrossingSimulationManager getBasicCrossingSimulationManager() {
        return new businessLogic.BasicCrossingSimulationManager(trafficLightFactory, crossingModeFactory);
    }

    @Override
    public AdvancedCrossingSimulationManager getAdvancedCrossingSimulationManager() {
        return new AdvancedCrossingSimulationManager(trafficLightFactory, crossingModeFactory);
    }
}
