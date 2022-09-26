package shapes;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShapeBaseTest {
    ShapeBase base = new ShapeBase("Star"){};

    @Test
    void getName() {
        assertThat(base.getName()).isEqualTo("Star Shape");
    }

    @Test
    void testToString() {
        assertThat(base.toString()).isEqualTo("Star Shape");
    }

    @Test
    void testAllState() {
        ArrowLeftShape arrowLeftShape = new ArrowLeftShape();
        ArrowRightShape arrowRightShape = new ArrowRightShape();
        ArrowForwardShape arrowForwardShape = new ArrowForwardShape();
        DonkeyShape donkeyShape = new DonkeyShape();
        DotShape dotShape = new DotShape();
        ManShape manShape = new ManShape();
        SoftAssertions s = new SoftAssertions();
        s.assertThat(arrowForwardShape.getName()).isEqualToIgnoringCase("Arrow Forward Shape");
        s.assertThat(arrowLeftShape.getName()).isEqualToIgnoringCase("Arrow Left Shape");
        s.assertThat(arrowRightShape.getName()).isEqualToIgnoringCase("Arrow Right Shape");
        s.assertThat(donkeyShape.getName()).isEqualToIgnoringCase("Donkey Shape");
        s.assertThat(dotShape.getName()).isEqualToIgnoringCase("Dot Shape");
        s.assertThat(manShape.getName()).isEqualToIgnoringCase("Man Shape");
        s.assertAll();
    }
}