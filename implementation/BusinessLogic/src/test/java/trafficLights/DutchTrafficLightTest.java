package trafficLights;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import shapes.ArrowForwardShape;
import shapes.ArrowLeftShape;
import shapes.DotShape;
import streetLightBehaviours.DutchStreetLightBehaviour;

import static org.assertj.core.api.Assertions.assertThat;

public class DutchTrafficLightTest {
    SimpleStreetTrafficLight trafficLight = new SimpleStreetTrafficLight(DutchStreetLightBehaviour.RED_LIGHT, "test");

    @Test
    void changeState() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.RED_LIGHT);
        trafficLight.changeState(DutchStreetLightBehaviour.GREEN_LIGHT);
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.GREEN_LIGHT);
        softly.assertAll();
    }

    @Test
    void startStopTraffic() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.GREEN_LIGHT);
        trafficLight.stopTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.RED_LIGHT);
        softly.assertAll();
    }

    @Test
    void getCurrentState() {
        assertThat(trafficLight.getCurrentState()).isEqualTo(DutchStreetLightBehaviour.RED_LIGHT);
    }

    @Test
    void testToString() {
        assertThat(trafficLight.toString()).isEqualTo("SimpleStreetTrafficLight{ currentState = RED_LIGHT, shape = Arrow Forward Shape }");
    }

    @Test
    void getShape() {
        assertThat(trafficLight.getShape()).isEqualTo(new ArrowForwardShape());
    }

    @Test
    void setShape() {
        var shape = new ArrowLeftShape();
        trafficLight.setShape(shape);
        assertThat(trafficLight.getShape()).isEqualTo(shape);
    }
}
