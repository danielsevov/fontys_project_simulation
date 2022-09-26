package crossingModes;

import interfaces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Test crossing modes. Utilizes Dutch light behavior.
 */
public class CrossingModesTest {


    PedestrianTrafficLight horizontalPedestrianTrafficLight;

    PedestrianTrafficLight verticalPedestrianTrafficLight;

    StreetTrafficLight horizontalStreetTrafficLightStraight;

    StreetTrafficLight verticalStreetTrafficLightStraight;

    StreetTrafficLight horizontalStreetTrafficLightLeft;

    StreetTrafficLight verticalStreetTrafficLightLeft;

    StreetTrafficLight horizontalStreetTrafficLightRight;

    StreetTrafficLight verticalStreetTrafficLightRight;


    StreetLightState dutchStreetLightBehaviour;


    PedestrianLightState dutchPedestrianLightBehaviour;

    // SUT
    CrossingMode sut;

    // List of all available SUTs
    //SimpleCrossingModeFactoryTest factory = new SimpleCrossingModeFactoryTest();
    //List<CrossingMode> modes = factory.getAllCrossingModes();

    Crossing mockedCrossing;

    @BeforeEach
    void setup(){

        horizontalPedestrianTrafficLight = mock(PedestrianTrafficLight.class);
        verticalPedestrianTrafficLight = mock(PedestrianTrafficLight.class);
        horizontalStreetTrafficLightStraight = mock(StreetTrafficLight.class);
        verticalStreetTrafficLightStraight = mock(StreetTrafficLight.class);
        horizontalStreetTrafficLightLeft = mock(StreetTrafficLight.class);
        verticalStreetTrafficLightLeft = mock(StreetTrafficLight.class);
        horizontalStreetTrafficLightRight = mock(StreetTrafficLight.class);
        verticalStreetTrafficLightRight = mock(StreetTrafficLight.class);

        dutchStreetLightBehaviour = mock(StreetLightState.class);
        dutchPedestrianLightBehaviour = mock(PedestrianLightState.class);

        mockedCrossing = mock(Crossing.class);

        mockedCrossing.addHorizontalLeft(horizontalStreetTrafficLightLeft);
        mockedCrossing.addHorizontalRight(horizontalStreetTrafficLightRight);

        mockedCrossing.addVerticalLeft(verticalStreetTrafficLightLeft);
        mockedCrossing.addVerticalRight(verticalStreetTrafficLightRight);

    }

    @Test
    void activateGermanModeTest() throws InterruptedException {

            sut = new GermanCrossingMode();
            mockedCrossing.setMode(sut);
//        Thread.sleep(2000);
            sut.activate(mockedCrossing, 1);

            verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
            verify(mockedCrossing, atLeast(0)).stopAllVertical();
            verify(mockedCrossing, atLeast(0)).startHorizontalRight();
            verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
            verify(mockedCrossing, atLeast(0)).startHorizontalLeft();
            verify(mockedCrossing, atLeast(0)).startVerticalStraight();
            verify(mockedCrossing, atLeast(0)).startVerticalRight();
            verify(mockedCrossing, atLeast(0)).startVerticalLeft();

    }

    @Test
    void activateBulgarianModeTest() throws InterruptedException {

        sut = new BulgarianCrossingMode();
        mockedCrossing.setMode(sut);
//        Thread.sleep(2000);
        sut.activate(mockedCrossing, 1);

        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).stopAllVertical();
        verify(mockedCrossing, atLeast(0)).startHorizontalRight();
        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).startHorizontalLeft();
        verify(mockedCrossing, atLeast(0)).startVerticalStraight();
        verify(mockedCrossing, atLeast(0)).startVerticalRight();
        verify(mockedCrossing, atLeast(0)).startVerticalLeft();
        verify(mockedCrossing, atLeast(0)).startPedestrianVertical();
        verify(mockedCrossing, atLeast(0)).startPedestrianHorizontal();

    }

    @Test
    void activateDutchModeTest() throws InterruptedException {

        sut = new DutchCrossingMode();
        mockedCrossing.setMode(sut);
//        Thread.sleep(2000);
        sut.activate(mockedCrossing, 1);
        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).stopAllVertical();
        verify(mockedCrossing, atLeast(0)).startHorizontalRight();
        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).startHorizontalLeft();
        verify(mockedCrossing, atLeast(0)).startVerticalStraight();
        verify(mockedCrossing, atLeast(0)).startVerticalRight();
        verify(mockedCrossing, atLeast(0)).startVerticalLeft();

    }

    @Test
    void activateSimpleGermanCrossingModeTest() throws InterruptedException {

        sut = new SimpleGermanCrossingMode();
        mockedCrossing.setMode(sut);
//        Thread.sleep(2000);
        sut.activate(mockedCrossing, 1);

        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).stopAllVertical();
//        verify(mockedCrossing, atLeast(1)).startHorizontalRight();
        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
//        verify(mockedCrossing, atLeast(1)).startHorizontalLeft();
        verify(mockedCrossing, atLeast(0)).startVerticalStraight();
//        verify(mockedCrossing, atLeast(1)).startVerticalRight();
//        verify(mockedCrossing, atLeast(1)).startVerticalLeft();

    }

    @Test
    void activateEmergencyCrossingModeTest() throws InterruptedException {

        sut = new EmergencyCrossingMode();
        mockedCrossing.setMode(sut);
//        Thread.sleep(2000);
        sut.activate(mockedCrossing, 1);

        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
        verify(mockedCrossing, atLeast(0)).stopAllVertical();
//        verify(mockedCrossing, atLeast(1)).startHorizontalRight();
        verify(mockedCrossing, atLeast(0)).stopAllHorizontal();
//        verify(mockedCrossing, atLeast(1)).startHorizontalLeft();
        verify(mockedCrossing, atLeast(0)).startVerticalStraight();
//        verify(mockedCrossing, atLeast(1)).startVerticalRight();
//        verify(mockedCrossing, atLeast(1)).startVerticalLeft();

    }

    @Test
    void getStreetLightBehaviour() {

    }

    @Test
    void getPedestrianLightBehaviour() {
    }

    @Test
    void deactivate() {
    }

}
