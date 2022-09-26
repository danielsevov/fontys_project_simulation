package assembler;

import interfaces.PedestrianLightState;
import pedestrianLightBehaviours.DutchPedestrianLightBehaviour;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapes.DonkeyShape;
import trafficLights.SimplePedestrianTrafficLight;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Just an example test to show that transitions of states are working properly
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class IntegrationTest {
    
    public IntegrationTest() {
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void trafficLightWithDutchPedestrianBehaviourTest(){
        SoftAssertions softly = new SoftAssertions();

        PedestrianLightState state = DutchPedestrianLightBehaviour.RED_LIGHT;
        SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state, "test");
        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> GREEN_BLINKING_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_BLINKING_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertAll();
    }

    @Test
    public void trafficLightWithGermanPedestrianBehaviourTest(){
        SoftAssertions softly = new SoftAssertions();

        PedestrianLightState state = GermanPedestrianLightBehaviour.RED_LIGHT;
        SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state, "test");
        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertAll();
    }

    @Test
    public void trafficLightWithLightBehaviourChangeTest(){
        SoftAssertions softly = new SoftAssertions();

        PedestrianLightState state = DutchPedestrianLightBehaviour.RED_LIGHT;
        SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state, "test");
        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> GREEN_BLINKING_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_BLINKING_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");

        outputStreamCaptor.reset();
        test.changeState(GermanPedestrianLightBehaviour.RED_LIGHT);
        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertAll();
    }

    @Test
    public void trafficLightWithShapeChangeTest(){
        SoftAssertions softly = new SoftAssertions();

        PedestrianLightState state = DutchPedestrianLightBehaviour.RED_LIGHT;
        SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state, "test");
        test.setShape(new DonkeyShape());

        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Donkey Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> GREEN_BLINKING_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_BLINKING_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Donkey Shape }");
        softly.assertAll();
    }

}
