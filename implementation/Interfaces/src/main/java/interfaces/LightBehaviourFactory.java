package interfaces;

/**
 * A factory for getting the traffic light behaviours.
 * The methods shall return the initial state which is the "stop" state
 * */
public interface LightBehaviourFactory {
    PedestrianLightState getInitialDutchPedestrianState();

    PedestrianLightState getInitialGermanPedestrianState();

    PedestrianLightState getInitialAustralianPedestrianState();

    StreetLightState getInitialDutchStreetState();

    StreetLightState getInitialGermanStreetState();

    StreetLightState getInitialBulgarianStreetState();

    PedestrianLightState getInitialBulgarianPedestrianState();
}
