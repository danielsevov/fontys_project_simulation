package crossings;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCrossing implements Crossing {
    CrossingMode currentMode;

    PedestrianTrafficLight horizontalPedestrianTrafficLight;
    PedestrianTrafficLight verticalPedestrianTrafficLight;

    StreetTrafficLight horizontalStreetTrafficLightStraight;
    StreetTrafficLight verticalStreetTrafficLightStraight;

    Optional<StreetTrafficLight> horizontalStreetTrafficLightLeft;
    Optional<StreetTrafficLight> verticalStreetTrafficLightLeft;

    Optional<StreetTrafficLight> horizontalStreetTrafficLightRight;
    Optional<StreetTrafficLight> verticalStreetTrafficLightRight;

    public SimpleCrossing(CrossingMode initialMode, PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        currentMode = initialMode;
        this.verticalPedestrianTrafficLight = verticalPedestrianTrafficLight;
        this.horizontalPedestrianTrafficLight = horizontalPedestrianTrafficLight;
        this.horizontalStreetTrafficLightStraight = horizontalStraight;
        this.verticalStreetTrafficLightStraight = verticalStraight;
        this.horizontalStreetTrafficLightLeft = Optional.empty();
        this.verticalStreetTrafficLightLeft = Optional.empty();
        this.horizontalStreetTrafficLightRight = Optional.empty();
        this.verticalStreetTrafficLightRight = Optional.empty();
    }

    @Override
    public void addHorizontalLeft(StreetTrafficLight light){
        this.horizontalStreetTrafficLightLeft = Optional.of(light);
    }

    @Override
    public void addHorizontalRight(StreetTrafficLight light){
        this.horizontalStreetTrafficLightRight = Optional.of(light);
    }

    @Override
    public void addVerticalLeft(StreetTrafficLight light){
        this.verticalStreetTrafficLightLeft = Optional.of(light);
    }

    @Override
    public void addVerticalRight(StreetTrafficLight light){
        this.verticalStreetTrafficLightRight = Optional.of(light);
    }

    @Override
    public void stopAllVertical(){
        this.verticalStreetTrafficLightStraight.stopTraffic();
        this.verticalStreetTrafficLightLeft.ifPresent(TrafficLight::stopTraffic);
        this.verticalStreetTrafficLightRight.ifPresent(TrafficLight::stopTraffic);
        this.verticalPedestrianTrafficLight.stopTraffic();
    }

    @Override
    public void stopAllHorizontal(){
        this.horizontalStreetTrafficLightStraight.stopTraffic();
        this.horizontalStreetTrafficLightLeft.ifPresent(TrafficLight::stopTraffic);
        this.horizontalStreetTrafficLightRight.ifPresent(TrafficLight::stopTraffic);
        this.horizontalPedestrianTrafficLight.stopTraffic();
    }

    @Override
    public void startHorizontalStraight(){
        this.verticalPedestrianTrafficLight.stopTraffic();
        this.horizontalPedestrianTrafficLight.startTraffic();
        this.horizontalStreetTrafficLightStraight.startTraffic();
    }

    @Override
    public void startVerticalStraight(){
        this.horizontalPedestrianTrafficLight.stopTraffic();
        this.verticalPedestrianTrafficLight.startTraffic();
        this.verticalStreetTrafficLightStraight.startTraffic();
    }

    @Override
    public void startHorizontalRight(){
        if(this.horizontalStreetTrafficLightRight.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.horizontalStreetTrafficLightRight.get().startTraffic();
        }
    }

    @Override
    public void startHorizontalLeft(){
        if(this.horizontalStreetTrafficLightLeft.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.horizontalStreetTrafficLightLeft.get().startTraffic();
        }
    }

    @Override
    public void startVerticalRight(){
        if(this.verticalStreetTrafficLightRight.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.verticalStreetTrafficLightRight.get().startTraffic();
        }
    }

    @Override
    public void startVerticalLeft(){
        if(this.verticalStreetTrafficLightLeft.isPresent()){
            this.horizontalPedestrianTrafficLight.stopTraffic();
            this.verticalPedestrianTrafficLight.stopTraffic();
            this.verticalStreetTrafficLightLeft.get().startTraffic();
        }
    }

    @Override
    public void startPedestrianHorizontal() {
        horizontalPedestrianTrafficLight.startTraffic();
    }

    @Override
    public void startPedestrianVertical() {
        verticalPedestrianTrafficLight.startTraffic();
    }

    @Override
    public void setMode(CrossingMode newMode) {
        this.currentMode = newMode;
    }

    @Override
    public void activate(int length){
        currentMode.activate(this, length);
    }

    @Override
    public void deactivate() {
        currentMode.deactivate();
    }

    @Override
    public void changeLightBehaviour(StreetLightState streetState, PedestrianLightState pedestrianState) {
        getAllPedestrianLights().forEach(pedestrianTrafficLight -> pedestrianTrafficLight.changeState(pedestrianState));
        getAllStreetLights().forEach(streetTrafficLight -> streetTrafficLight.changeState(streetState));
    }

    private List<StreetTrafficLight> getAllStreetLights() {
        List<StreetTrafficLight> allStreetLights = new ArrayList<>();
        allStreetLights.add(horizontalStreetTrafficLightStraight);
        allStreetLights.add(verticalStreetTrafficLightStraight);
        this.horizontalStreetTrafficLightRight.ifPresent(allStreetLights::add);
        this.horizontalStreetTrafficLightLeft.ifPresent(allStreetLights::add);
        this.verticalStreetTrafficLightRight.ifPresent(allStreetLights::add);
        this.verticalStreetTrafficLightLeft.ifPresent(allStreetLights::add);
        return allStreetLights;
    }

    private List<PedestrianTrafficLight> getAllPedestrianLights() {
        return List.of(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight);
    }
}
