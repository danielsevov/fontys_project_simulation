package factories;

import interfaces.LightBehaviourFactory;
import interfaces.PedestrianLightState;
import interfaces.StreetLightState;
import pedestrianLightBehaviours.AustralianPedestrianLightBehaviour;
import pedestrianLightBehaviours.BulgarianPedestrianLightBehaviour;
import pedestrianLightBehaviours.DutchPedestrianLightBehaviour;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import streetLightBehaviours.BulgarianStreetLightBehaviour;
import streetLightBehaviours.DutchStreetLightBehaviour;
import streetLightBehaviours.GermanStreetLightBehaviour;

public class SimpleLightBehaviourFactory implements LightBehaviourFactory {
    @Override
    public PedestrianLightState getInitialDutchPedestrianState() {
        return DutchPedestrianLightBehaviour.RED_LIGHT;
    }

    @Override
    public PedestrianLightState getInitialGermanPedestrianState() {
        return GermanPedestrianLightBehaviour.RED_LIGHT;
    }

    @Override
    public PedestrianLightState getInitialAustralianPedestrianState() {
        return AustralianPedestrianLightBehaviour.RED_LIGHT;
    }

    @Override
    public StreetLightState getInitialDutchStreetState() {
        return DutchStreetLightBehaviour.RED_LIGHT;
    }

    @Override
    public StreetLightState getInitialGermanStreetState() {
        return GermanStreetLightBehaviour.RED_LIGHT;
    }

    @Override
    public StreetLightState getInitialBulgarianStreetState() {
        return BulgarianStreetLightBehaviour.RED_LIGHT;
    }

    @Override
    public PedestrianLightState getInitialBulgarianPedestrianState() {
        return BulgarianPedestrianLightBehaviour.RED_LIGHT;
    }
}
