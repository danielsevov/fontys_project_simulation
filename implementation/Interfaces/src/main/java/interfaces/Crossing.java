package interfaces;

import java.util.List;

public interface Crossing {

    void activate(int length);

    void deactivate();

    void addHorizontalLeft(StreetTrafficLight light);

    void addHorizontalRight(StreetTrafficLight light);

    void addVerticalLeft(StreetTrafficLight light);

    void addVerticalRight(StreetTrafficLight light);

    void stopAllVertical();

    void stopAllHorizontal();

    void startHorizontalStraight();

    void startVerticalStraight();

    void startHorizontalRight();

    void startHorizontalLeft();

    void startVerticalRight();

    void startVerticalLeft();

    void startPedestrianHorizontal();

    void startPedestrianVertical();

    void setMode(CrossingMode newMode);

    void changeLightBehaviour(StreetLightState streetState, PedestrianLightState pedestrianState);

}
