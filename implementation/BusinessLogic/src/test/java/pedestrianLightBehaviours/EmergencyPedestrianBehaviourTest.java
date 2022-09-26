package pedestrianLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmergencyPedestrianBehaviourTest {

    // Init the LightBehaviour
    EmergencyPedestrianLightBehaviour yellow = EmergencyPedestrianLightBehaviour.YELLOW_BLINKING_LIGHT;
    EmergencyPedestrianLightBehaviour noLight = EmergencyPedestrianLightBehaviour.NO_LIGHT;

    @Test
    void stateTransitions() {
        SoftAssertions s = new SoftAssertions();
        s.assertThat(yellow.getNext()).isEqualTo(noLight);
        s.assertThat(noLight.getNext()).isEqualTo(yellow);
        s.assertAll();
    }

    @Test
    void yellowLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellow.stateMeaning()).isEqualTo(LightState.LightStateMeaning.PASS);
            s.assertThat(yellow.getName()).isEqualTo("Emergency Light");
            s.assertAll();
        });

    }

    @Test
    void noLightLightCheckValues() {
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(noLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.STOP);
            s.assertThat(noLight.getName()).isEqualTo("Emergency Light");
            s.assertAll();
        });

    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

        Arrays.stream(EmergencyPedestrianLightBehaviour.values()).forEach(emergencyPedestrianLightBehaviour -> {
            String colorHex = emergencyPedestrianLightBehaviour.getColorHex();
            s.assertThat(colorHex.length()).isEqualTo(7);
        });
        s.assertAll();
    }
}
