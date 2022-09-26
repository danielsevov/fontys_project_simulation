package trafficLights;

import interfaces.*;
import shapes.ArrowForwardShape;
import shapes.DotShape;

/**
 * Instance object implementing StreetTrafficLight interface
 */
public class SimpleStreetTrafficLight extends TrafficLightBase implements StreetTrafficLight {
    private StreetLightState currentState;
    private StreetShape shape;

    public SimpleStreetTrafficLight(StreetLightState initialState, String name) {
        super(name);
        this.currentState = initialState;
        this.shape = new ArrowForwardShape();
    }

    @Override
    public void changeState(StreetLightState newState) {
        currentState = newState;
    }

    @Override
    public void stopTraffic() {
        while (currentState.stateMeaning() != LightState.LightStateMeaning.STOP) {
            currentState.changeState(this);
        }
    }

    @Override
    public void startTraffic() {
        while (currentState.stateMeaning() != LightState.LightStateMeaning.PASS) {
            currentState.changeState(this);
        }
    }

    @Override
    public void changeToNextState() {
        currentState.changeState(this);
    }

    @Override
    public StreetLightState getCurrentState() {
        return currentState;
    }

    @Override
    public StreetShape getShape() {
        return shape;
    }

    @Override
    public void setShape(StreetShape newShape) {
        this.shape = newShape;
        informForShapeChange(newShape);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                " currentState = " + getCurrentState() +
                ", shape = " + shape +
                " }";
    }
}
