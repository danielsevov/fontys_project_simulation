package pedestrianLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.BulgarianStreetLightBehaviour;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AustralianPedestrianBehaviourTest {
    AustralianPedestrianLightBehaviour redLight = AustralianPedestrianLightBehaviour.RED_LIGHT;
    AustralianPedestrianLightBehaviour greenLight = AustralianPedestrianLightBehaviour.GREEN_LIGHT;
    AustralianPedestrianLightBehaviour redBlinkingLight = AustralianPedestrianLightBehaviour.RED_BLINKING_LIGHT;

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
        assertThat(greenLight.getNext()).isEqualTo(redBlinkingLight);
    }

    @Test
    void redBlinkingLightGetNextTest() {
        assertThat(redBlinkingLight.getNext()).isEqualTo(redLight);
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
    void redBlinkingLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(redBlinkingLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            s.assertThat(redBlinkingLight.getName()).isEqualTo("Red Blinking Light");
            s.assertAll();
        });

    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

        Arrays.stream(AustralianPedestrianLightBehaviour.values()).forEach(australianPedestrianLightBehaviour -> {
            String colorHex = australianPedestrianLightBehaviour.getColorHex();
            s.assertThat(colorHex.length()).isEqualTo(7);
        });
        s.assertAll();
    }
}
