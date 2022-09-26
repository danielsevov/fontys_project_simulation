package interfaces;

/**
 * A factory for creating the traffic lights with different behaviours.
 * The initial state for each traffic light should be the "stop" state
 * */
public interface TrafficLightFactory {
    PedestrianTrafficLight createDutchPedestrianTrafficLight(String name);

    PedestrianTrafficLight createGermanPedestrianTrafficLight(String name);

    PedestrianTrafficLight createAustralianPedestrianTrafficLight(String name);

    StreetTrafficLight createDutchStreetTrafficLight(String name);

    StreetTrafficLight createGermanStreetTrafficLight(String name);

    StreetTrafficLight createBulgarianStreetTrafficLight(String name);

    LightBehaviourFactory getLightBehaviourFactory();
}
