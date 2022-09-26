package crossingModes;

import interfaces.*;
import pedestrianLightBehaviours.EmergencyPedestrianLightBehaviour;
import streetLightBehaviours.EmergencyStreetLightBehaviour;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EmergencyCrossingMode implements CrossingMode {

    Timer timer;

    public EmergencyCrossingMode(){
        resetTimer();
    }

    private void resetTimer(){
        timer = new Timer();
    }

    @Override
    public void activate(Crossing crossing, int length) {
        crossing.changeLightBehaviour(getStreetLightBehaviour(), getPedestrianLightBehaviour());

        resetTimer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Emergency Mode ---\n");
                crossing.stopAllHorizontal();
                crossing.startVerticalStraight();
            }
        }, 0, length);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Emergency Mode ---\n");
                crossing.stopAllVertical();
                crossing.startHorizontalStraight();

            }
        }, length/2, length);
    }

    /**
     * Deactivates crossing logic loop.
     */
    @Override
    public void deactivate() {
        timer.cancel();
    }

    @Override
    public PedestrianLightState getPedestrianLightBehaviour() {
        return EmergencyPedestrianLightBehaviour.YELLOW_BLINKING_LIGHT;
    }

    @Override
    public StreetLightState getStreetLightBehaviour() {
        return EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT;
    }
}
