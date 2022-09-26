package factories;

import interfaces.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

public class SimpleTrafficLightFactoryTest {

    TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();
    PedestrianTrafficLight dutchPedestrianLight = new SimplePedestrianTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialDutchPedestrianState(),"dutch pedestrian light");
    PedestrianTrafficLight germanPedestrianLight = new SimplePedestrianTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialGermanPedestrianState(),"german pedestrian light");
    PedestrianTrafficLight australianPedestrianLight = new SimplePedestrianTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialAustralianPedestrianState(),"australian pedestrian light");
    StreetTrafficLight dutchStreetLight = new SimpleStreetTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialDutchStreetState(),"dutch street light");
    StreetTrafficLight germanStreetLight = new SimpleStreetTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialGermanStreetState(),"german street light");
    StreetTrafficLight bulgarianStreetLight = new SimpleStreetTrafficLight(trafficLightFactory.getLightBehaviourFactory().getInitialBulgarianStreetState(), "bulgarian street light");

    @Test
    public void testPedestrianTrafficLightFactory(){
        SoftAssertions.assertSoftly(softAssertions -> {
           softAssertions.assertThat(trafficLightFactory.createDutchPedestrianTrafficLight("dutch pedestrian light").toString()).isEqualTo(dutchPedestrianLight.toString());
           softAssertions.assertThat(trafficLightFactory.createGermanPedestrianTrafficLight("german pedestrian light").toString()).isEqualTo(germanPedestrianLight.toString());
            softAssertions.assertThat(trafficLightFactory.createAustralianPedestrianTrafficLight("australian pedestrian light").toString()).isEqualTo(australianPedestrianLight.toString());
            softAssertions.assertThat(trafficLightFactory.createDutchPedestrianTrafficLight("dutch pedestrian light").toString()).isEqualTo(dutchPedestrianLight.toString());

        });
    }

    @Test
    public void testStreetTrafficLightFactory(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(trafficLightFactory.createDutchStreetTrafficLight("dutch street light").toString()).isEqualTo(dutchStreetLight.toString());
            softAssertions.assertThat(trafficLightFactory.createGermanStreetTrafficLight("german street light").toString()).isEqualTo(germanStreetLight.toString());
            softAssertions.assertThat(trafficLightFactory.createBulgarianStreetTrafficLight("bulgarian street light").toString()).isEqualTo(bulgarianStreetLight.toString());

        });
    }


}
