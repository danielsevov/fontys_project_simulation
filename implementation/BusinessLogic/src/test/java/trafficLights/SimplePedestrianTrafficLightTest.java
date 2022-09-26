package trafficLights;

import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import shapes.DotShape;
import streetLightBehaviours.GermanStreetLightBehaviour;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePedestrianTrafficLightTest {

    SimplePedestrianTrafficLight trafficLight = new SimplePedestrianTrafficLight(GermanPedestrianLightBehaviour.RED_LIGHT, "test");

    @Test
    void changeState() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.changeState(GermanPedestrianLightBehaviour.GREEN_LIGHT);
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.GREEN_LIGHT);
        softly.assertAll();
    }

    @Test
    void stopTraffic() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.GREEN_LIGHT);
        trafficLight.stopTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.RED_LIGHT);
        softly.assertAll();
    }

    @Test
    void startTraffic() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.GREEN_LIGHT);
        softly.assertAll();
    }

    @Test
    void getCurrentState() {
        assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.RED_LIGHT);
    }

    @Test
    void testToString() {
        assertThat(trafficLight.toString()).isEqualTo("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
    }

    @Test
    void getShape() {
        assertThat(trafficLight.getShape()).isEqualTo(new DotShape());
    }

    @Test
    void setShape() {
        var shape = new DotShape();
        trafficLight.setShape(shape);
        assertThat(trafficLight.getShape()).isEqualTo(shape);
    }

    @Test
    void changeToNextState() {
        trafficLight.stopTraffic();
        trafficLight.changeToNextState();
        assertThat(trafficLight.getCurrentState()).isEqualTo(GermanPedestrianLightBehaviour.GREEN_LIGHT);
    }
}