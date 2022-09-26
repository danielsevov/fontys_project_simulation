package trafficLights;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Instance object implementing TrafficLight interface
 *
 */
public abstract class TrafficLightBase implements TrafficLight {
    private final String name;
    private final List<LightObserver> lightObservers;
    private final List<ShapeObserver> shapeObservers;

    public TrafficLightBase(String name){
        this.name = name;
        lightObservers = new ArrayList<>();
        shapeObservers = new ArrayList<>();
    }

    @Override
    public abstract void stopTraffic();

    @Override
    public abstract void startTraffic();

    @Override
    public abstract LightState getCurrentState();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addLightObserver(LightObserver o) {
        lightObservers.add(o);
    }

    @Override
    public void removeLightObserver(LightObserver o) {
        lightObservers.remove(o);
    }

    @Override
    public void informForLightChange() {
        lightObservers.forEach(s -> s.update(getCurrentState()));
    }

    @Override
    public void addShapeObserver(ShapeObserver o) {
        shapeObservers.add(o);
    }

    @Override
    public void informForShapeChange(Shape shape) {
        shapeObservers.forEach(s -> s.update(shape));
    }
}
