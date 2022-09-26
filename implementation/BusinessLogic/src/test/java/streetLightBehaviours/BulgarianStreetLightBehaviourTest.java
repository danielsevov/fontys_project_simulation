package streetLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.BulgarianStreetLightBehaviour;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BulgarianStreetLightBehaviourTest {
    BulgarianStreetLightBehaviour redLight = BulgarianStreetLightBehaviour.RED_LIGHT;
    BulgarianStreetLightBehaviour greenLight = BulgarianStreetLightBehaviour.GREEN_LIGHT;
    BulgarianStreetLightBehaviour yellowLightBefore = BulgarianStreetLightBehaviour.YELLOW_LIGHT_BEFORE_GREEN;
    BulgarianStreetLightBehaviour yellowLightAfter = BulgarianStreetLightBehaviour.YELLOW_LIGHT_AFTER_GREEN;

    @Test
    public void redLightGetNextTest(){
        assertThat(redLight.getNext()).isEqualTo(yellowLightBefore);
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
    void yellowLightBeforeGetNextTest() {
        assertThat(yellowLightBefore.getNext()).isEqualTo(greenLight);
    }


    @Test
    void yellowLightBeforeCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellowLightBefore.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            s.assertThat(yellowLightBefore.getName()).isEqualTo("Yellow Light");
            s.assertAll();
        });

    }

    @Test
    void greenLightGetNextTest() {
        assertThat(greenLight.getNext()).isEqualTo(yellowLightAfter);
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
    void yellowLightAfterGetNextTest() {
        assertThat(yellowLightAfter.getNext()).isEqualTo(redLight);
    }


    @Test
    void yellowLightAfterCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellowLightAfter.stateMeaning()).isEqualTo(LightState.LightStateMeaning.TRANSITION);
            s.assertThat(yellowLightAfter.getName()).isEqualTo("Yellow Light");
            s.assertAll();
        });

    }

    @Test
    void testColorCode() {
        SoftAssertions s = new SoftAssertions();

      Arrays.stream(BulgarianStreetLightBehaviour.values()).forEach(bulgarianStreetLightBehaviour -> {
          String colorHex = bulgarianStreetLightBehaviour.getColorHex();
          s.assertThat(colorHex.length()).isEqualTo(7);
      });
      s.assertAll();
    }
}
