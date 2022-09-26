package pedestrianLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pedestrianLightBehaviours.DutchPedestrianLightBehaviour;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DutchPedestrianLightBehaviourTest {
    DutchPedestrianLightBehaviour redLight = DutchPedestrianLightBehaviour.RED_LIGHT;
    DutchPedestrianLightBehaviour greenLight = DutchPedestrianLightBehaviour.GREEN_LIGHT;
    DutchPedestrianLightBehaviour greenBlinkingLight = DutchPedestrianLightBehaviour.GREEN_BLINKING_LIGHT;

    @Test
    public void redLightGetNextTest(){
        assertThat(redLight.getNext()).isEqualTo(greenLight);
    }

    @Test
    void redLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(redLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.STOP);
            s.assertThat(redLight.getName()).isEqualTo("Red Light");
            s.assertAll();
        });

    }

    @Test
    void greenLightGetNextTest() {
        assertThat(greenLight.getNext()).isEqualTo(greenBlinkingLight);
    }

    @Test
    void greenBlinkingLightGetNextTest() {
        assertThat(greenBlinkingLight.getNext()).isEqualTo(redLight);
    }

    @Test
    void greenLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(greenLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.PASS);
            s.assertThat(greenLight.getName()).isEqualTo("Green Light");
            s.assertAll();
        });

    }

    @Test
    void greenBlinkingLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(greenBlinkingLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            s.assertThat(greenBlinkingLight.getName()).isEqualTo("Green Blinking Light");
            s.assertAll();
        });

    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

        Arrays.stream(DutchPedestrianLightBehaviour.values()).forEach(dutchPedestrianLightBehaviour -> {
            String colorHex = dutchPedestrianLightBehaviour.getColorHex();
            s.assertThat(colorHex.length()).isEqualTo(7);
        });
        s.assertAll();
    }
}
