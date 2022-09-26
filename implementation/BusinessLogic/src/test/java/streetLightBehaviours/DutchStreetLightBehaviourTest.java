package streetLightBehaviours;

import factories.SimpleTrafficLightFactory;
import interfaces.LightState;
import interfaces.TrafficLightFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DutchStreetLightBehaviourTest {
    DutchStreetLightBehaviour redLight = DutchStreetLightBehaviour.RED_LIGHT;
    DutchStreetLightBehaviour yellowLight = DutchStreetLightBehaviour.YELLOW_LIGHT;
    DutchStreetLightBehaviour greenLight = DutchStreetLightBehaviour.GREEN_LIGHT;
    TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

    @Test
    public void changeStateTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getNext()).isEqualTo(greenLight);
            softAssertions.assertThat(greenLight.getNext()).isEqualTo(yellowLight);
            softAssertions.assertThat(yellowLight.getNext()).isEqualTo(redLight);
        });
    }

    @Test
    public void checkNameTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getName()).isEqualTo("Red Light");
            softAssertions.assertThat(yellowLight.getName()).isEqualTo("Yellow Light");
            softAssertions.assertThat(greenLight.getName()).isEqualTo("Green Light");

        });
    }

    @Test
    public void checkPassTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.STOP);
            softAssertions.assertThat(yellowLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            softAssertions.assertThat(greenLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.PASS);
        });
    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

        Arrays.stream(DutchStreetLightBehaviour.values()).forEach(dutchStreetLightBehaviour -> {
            String colorHex = dutchStreetLightBehaviour.getColorHex();
            s.assertThat(colorHex.length()).isEqualTo(7);
        });
        s.assertAll();
    }

}
