package factories;

import interfaces.LightBehaviourFactory;
import interfaces.PedestrianLightState;
import interfaces.StreetLightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import pedestrianLightBehaviours.AustralianPedestrianLightBehaviour;
import pedestrianLightBehaviours.DutchPedestrianLightBehaviour;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import streetLightBehaviours.BulgarianStreetLightBehaviour;
import streetLightBehaviours.DutchStreetLightBehaviour;
import streetLightBehaviours.GermanStreetLightBehaviour;

import static org.mockito.Mockito.when;


public class SimpleLightBehaviourFactoryTest {

    PedestrianLightState dutchPedestrianLightBehaviour = DutchPedestrianLightBehaviour.RED_LIGHT;
    PedestrianLightState germanPedestrianLightBehaviour = GermanPedestrianLightBehaviour.RED_LIGHT;
    PedestrianLightState australianPedestrianLightBehaviour = AustralianPedestrianLightBehaviour.RED_LIGHT;

    StreetLightState dutchStreetLightBehaviour = DutchStreetLightBehaviour.RED_LIGHT;
    StreetLightState germanStreetLightBehaviour = GermanStreetLightBehaviour.RED_LIGHT;
    StreetLightState bulgarianStreetLightBehaviour = BulgarianStreetLightBehaviour.RED_LIGHT;


    LightBehaviourFactory lightBehaviourFactory =  new SimpleLightBehaviourFactory();


    @Test
    public void testPedestrianTrafficLightFactory(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(lightBehaviourFactory.getInitialDutchPedestrianState()).isEqualTo(dutchPedestrianLightBehaviour);
            softAssertions.assertThat(lightBehaviourFactory.getInitialGermanPedestrianState()).isEqualTo(germanPedestrianLightBehaviour);
            softAssertions.assertThat(lightBehaviourFactory.getInitialAustralianPedestrianState()).isEqualTo(australianPedestrianLightBehaviour);


        });
    }

    @Test
    public void testStreetTrafficLightFactory(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(lightBehaviourFactory.getInitialDutchStreetState()).isEqualTo(dutchStreetLightBehaviour);
            softAssertions.assertThat(lightBehaviourFactory.getInitialGermanStreetState()).isEqualTo(germanStreetLightBehaviour);
            softAssertions.assertThat(lightBehaviourFactory.getInitialBulgarianStreetState()).isEqualTo(bulgarianStreetLightBehaviour);


        });
    }
}
