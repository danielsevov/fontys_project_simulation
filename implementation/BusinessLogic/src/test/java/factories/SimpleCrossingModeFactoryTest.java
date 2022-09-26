package factories;

import crossingModes.DutchCrossingMode;
import crossingModes.EmergencyCrossingMode;
import crossingModes.GermanCrossingMode;
import crossingModes.SimpleGermanCrossingMode;
import interfaces.CrossingMode;
import interfaces.CrossingModeFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertThat;


public class SimpleCrossingModeFactoryTest {
    CrossingModeFactory factory = new SimpleCrossingModeFactory();

   CrossingMode simpleGerman = new SimpleGermanCrossingMode();
    CrossingMode german = new GermanCrossingMode();
    CrossingMode emergency = new EmergencyCrossingMode();
    CrossingMode dutch = new DutchCrossingMode();

    @Test
    public void testFactory(){
        List<CrossingMode> allCrossingModes = factory.getAllCrossingModes();
        Collection<CrossingMode> collection = new ArrayList<>();
        collection.add(simpleGerman);
        collection.add(german);
        collection.add(emergency);
        collection.add(dutch);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(factory.createSimpleCrossingMode()).isNotNull();
            softAssertions.assertThat(factory.createDutchCrossingMode()).isNotNull();
            softAssertions.assertThat(factory.createGermanCrossingMode()).isNotNull();
            softAssertions.assertThat(factory.createEmergencyCrossingMode()).isNotNull();
            softAssertions.assertThat(allCrossingModes.contains(collection));

        });
    }

    @Test
    public void testGetAllCrossingModes(){
        List<CrossingMode> allCrossingModes = factory.getAllCrossingModes();
        Collection<CrossingMode> collection = new ArrayList<>();
        collection.add(simpleGerman);
        collection.add(german);
        collection.add(emergency);
        collection.add(dutch);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(allCrossingModes).isNotNull();
            softAssertions.assertThat(allCrossingModes.contains(collection));

        });
    }

}
