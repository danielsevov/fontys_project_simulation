package streetLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.GermanStreetLightBehaviour;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GermanStreetLightBehaviourTest {

    GermanStreetLightBehaviour redLight = GermanStreetLightBehaviour.RED_LIGHT;
    GermanStreetLightBehaviour redYellow = GermanStreetLightBehaviour.RED_YELLOW;
    GermanStreetLightBehaviour greenLight = GermanStreetLightBehaviour.GREEN_LIGHT;
    GermanStreetLightBehaviour yellow = GermanStreetLightBehaviour.YELLOW;


    @Test
    public void changeStateTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getNext()).isEqualTo(redYellow);
            softAssertions.assertThat(redYellow.getNext()).isEqualTo(greenLight);
            softAssertions.assertThat(greenLight.getNext()).isEqualTo(yellow);
            softAssertions.assertThat(yellow.getNext()).isEqualTo(redLight);
        });
    }

    @Test
    public void checkNameTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getName()).isEqualTo("Red Light");
            softAssertions.assertThat(redYellow.getName()).isEqualTo("Red Yellow Light");
            softAssertions.assertThat(yellow.getName()).isEqualTo("Yellow Light");
            softAssertions.assertThat(greenLight.getName()).isEqualTo("Green Light");

        });
    }

    @Test
    public void checkPassTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.STOP);
            softAssertions.assertThat(redYellow.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            softAssertions.assertThat(yellow.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            softAssertions.assertThat(greenLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.PASS);
        });
    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

        Arrays.stream(GermanStreetLightBehaviour.values()).forEach(germanStreetLightBehaviour -> {
            String colorHex = germanStreetLightBehaviour.getColorHex();
            s.assertThat(colorHex.length()).isEqualTo(7);
        });
        s.assertAll();
    }
}
