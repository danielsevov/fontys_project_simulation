package crossings;

import interfaces.*;

public class BasicObservableCrossing extends SimpleCrossing implements interfaces.BasicObservableCrossing {
    public BasicObservableCrossing(CrossingMode initialMode, PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(initialMode, horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void addHorizontalPedestrianLightObserver(LightObserver observer) {
        super.horizontalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addVerticalPedestrianLightObserver(LightObserver observer) {
        super.verticalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addHorizontalStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightStraight.addLightObserver(observer);
    }

    @Override
    public void addVerticalStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightStraight.addLightObserver(observer);
    }
}
