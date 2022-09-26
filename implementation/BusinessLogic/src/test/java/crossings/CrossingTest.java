package crossings;

import crossingModes.EmergencyCrossingMode;
import interfaces.Crossing;
import interfaces.CrossingMode;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import pedestrianLightBehaviours.EmergencyPedestrianLightBehaviour;
import streetLightBehaviours.EmergencyStreetLightBehaviour;

import java.util.List;

import static org.mockito.Mockito.*;

public class CrossingTest {

    private PedestrianTrafficLight horizontalPed;
    private PedestrianTrafficLight verticalPed;
    private StreetTrafficLight horizontalStreet;
    private StreetTrafficLight horizontalStreetLeft;
    private StreetTrafficLight horizontalStreetRight;
    private StreetTrafficLight verticalStreet;
    private StreetTrafficLight verticalStreetLeft;
    private StreetTrafficLight verticalStreetRight;
    private CrossingMode mode;
    private Crossing crossing;
    private InOrder inOrder;

    @BeforeEach
    void setUp() {
        horizontalPed = mock(PedestrianTrafficLight.class);
        verticalPed = mock(PedestrianTrafficLight.class);
        horizontalStreet = mock(StreetTrafficLight.class);
        horizontalStreetLeft = mock(StreetTrafficLight.class);
        horizontalStreetRight = mock(StreetTrafficLight.class);
        verticalStreet = mock(StreetTrafficLight.class);
        verticalStreetLeft = mock(StreetTrafficLight.class);
        verticalStreetRight = mock(StreetTrafficLight.class);
        mode = mock(CrossingMode.class);
        crossing = new SimpleCrossing(mode, horizontalPed, verticalPed, horizontalStreet, verticalStreet);
        inOrder = inOrder(horizontalPed, verticalPed, verticalStreet, verticalStreetLeft,
                verticalStreetRight, horizontalStreet, horizontalStreetLeft, horizontalStreetRight);
    }

    @Test
    void t01testCrossingSequence() {
        crossing.stopAllVertical();
        crossing.startHorizontalStraight();
        inOrder.verify(verticalStreet).stopTraffic();
        inOrder.verify(verticalPed, times(2)).stopTraffic();
        inOrder.verify(horizontalPed).startTraffic();
        inOrder.verify(horizontalStreet).startTraffic();

        crossing.stopAllHorizontal();
        crossing.startVerticalStraight();
        inOrder.verify(horizontalStreet).stopTraffic();
        inOrder.verify(horizontalPed, times(2)).stopTraffic();
        inOrder.verify(verticalPed).startTraffic();
        inOrder.verify(verticalStreet).startTraffic();
    }

    @Test
    void activate() {
        crossing.activate(100);
        verify(mode, times(1)).activate(crossing, 100);
    }

    @Test
    void deactivate() {
        crossing.deactivate();
        verify(mode, times(1)).deactivate();
    }

    @Test
    void stopAllVerticalEasyCase() {
        crossing.stopAllVertical();
        inOrder.verify(verticalStreet).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
    }

    @Test
    void stopAllVertical() {
        addOptionalTrafficLights();
        crossing.stopAllVertical();
        inOrder.verify(verticalStreet).stopTraffic();
        inOrder.verify(verticalStreetLeft).stopTraffic();
        inOrder.verify(verticalStreetRight).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
    }

    @Test
    void stopAllHorizontalSimpleCase() {
        crossing.stopAllHorizontal();
        inOrder.verify(horizontalStreet).stopTraffic();
        inOrder.verify(horizontalPed).stopTraffic();
    }

    @Test
    void stopAllHorizontal() {
        addOptionalTrafficLights();
        crossing.stopAllHorizontal();
        inOrder.verify(horizontalStreet).stopTraffic();
        inOrder.verify(horizontalStreetLeft).stopTraffic();
        inOrder.verify(horizontalStreetRight).stopTraffic();
        inOrder.verify(horizontalPed).stopTraffic();
    }

    @Test
    void startHorizontalStraight() {
        crossing.startHorizontalStraight();
        inOrder.verify(verticalPed).stopTraffic();
        inOrder.verify(horizontalPed).startTraffic();
        inOrder.verify(horizontalStreet).startTraffic();
    }

    @Test
    void startVerticalStraight() {
        crossing.startVerticalStraight();
        inOrder.verify(horizontalPed).stopTraffic();
        inOrder.verify(verticalPed).startTraffic();
        inOrder.verify(verticalStreet).startTraffic();
    }

    @Test
    void startHorizontalRight() {
        addOptionalTrafficLights();
        crossing.startHorizontalRight();
        inOrder.verify(horizontalPed).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
        inOrder.verify(horizontalStreetRight).startTraffic();
    }

    @Test
    void startHorizontalLeft() {
        addOptionalTrafficLights();
        crossing.startHorizontalLeft();
        inOrder.verify(horizontalPed).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
        inOrder.verify(horizontalStreetLeft).startTraffic();
    }

    @Test
    void startVerticalRight() {
        addOptionalTrafficLights();
        crossing.startVerticalRight();
        inOrder.verify(horizontalPed).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
        inOrder.verify(verticalStreetRight).startTraffic();
    }

    @Test
    void startVerticalLeft() {
        addOptionalTrafficLights();
        crossing.startVerticalLeft();
        inOrder.verify(horizontalPed).stopTraffic();
        inOrder.verify(verticalPed).stopTraffic();
        inOrder.verify(verticalStreetLeft).startTraffic();
    }

    @Test
    void changeLightBehaviour() {
        addOptionalTrafficLights();
        crossing.setMode(new EmergencyCrossingMode());
        crossing.activate(1000);
        crossing.deactivate();
        verify(horizontalPed).changeState(EmergencyPedestrianLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(verticalPed).changeState(EmergencyPedestrianLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(horizontalStreet).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(horizontalStreetLeft).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(horizontalStreetRight).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(verticalStreet).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(verticalStreetLeft).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        verify(verticalStreetRight).changeState(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
    }

    private void addOptionalTrafficLights() {
        crossing.addHorizontalLeft(horizontalStreetLeft);
        crossing.addHorizontalRight(horizontalStreetRight);
        crossing.addVerticalLeft(verticalStreetLeft);
        crossing.addVerticalRight(verticalStreetRight);
    }
}
