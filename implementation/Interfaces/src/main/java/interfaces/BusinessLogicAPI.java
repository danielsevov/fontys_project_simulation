package interfaces;

public interface BusinessLogicAPI {
    PedestrianTrafficLightSimulationManager getPedestrianLightSimulationManager();

    StreetTrafficLightSimulationManager getStreetLightSimulationManager();

    BasicCrossingSimulationManager getBasicCrossingSimulationManager();

    AdvancedCrossingSimulationManager getAdvancedCrossingSimulationManager();
}
