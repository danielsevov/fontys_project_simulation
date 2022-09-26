package factories;

import interfaces.LightBehaviourFactory;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLightFactory;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

public class SimpleTrafficLightFactory implements TrafficLightFactory {
    private final LightBehaviourFactory lightBehaviourFactory = new SimpleLightBehaviourFactory();

    @Override
    public PedestrianTrafficLight createDutchPedestrianTrafficLight(String name) {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialDutchPedestrianState(), name);
    }

    @Override
    public PedestrianTrafficLight createGermanPedestrianTrafficLight(String name) {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialGermanPedestrianState(), name);
    }

    @Override
    public PedestrianTrafficLight createAustralianPedestrianTrafficLight(String name) {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialAustralianPedestrianState(), name);
    }

    @Override
    public StreetTrafficLight createDutchStreetTrafficLight(String name) {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialDutchStreetState(), name);
    }

    @Override
    public StreetTrafficLight createGermanStreetTrafficLight(String name) {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialGermanStreetState(), name);
    }

    @Override
    public StreetTrafficLight createBulgarianStreetTrafficLight(String name) {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialBulgarianStreetState(), name);
    }

    @Override
    public LightBehaviourFactory getLightBehaviourFactory() {
        return lightBehaviourFactory;
    }
}
