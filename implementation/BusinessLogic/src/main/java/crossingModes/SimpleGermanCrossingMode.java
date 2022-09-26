package crossingModes;

import interfaces.Crossing;
import interfaces.CrossingMode;
import interfaces.PedestrianLightState;
import interfaces.StreetLightState;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import streetLightBehaviours.GermanStreetLightBehaviour;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleGermanCrossingMode implements CrossingMode {
    Timer timer;

    @Override
    public StreetLightState getStreetLightBehaviour() {
        return GermanStreetLightBehaviour.RED_LIGHT;
    }

    @Override
    public PedestrianLightState getPedestrianLightBehaviour() {
        return GermanPedestrianLightBehaviour.RED_LIGHT;
    }

    public SimpleGermanCrossingMode(){
        resetTimer();
    }

    private void resetTimer(){
        timer = new Timer();
    }

    @Override
    public void activate(Crossing crossing, int length) {
        resetTimer();
        crossing.changeLightBehaviour(getStreetLightBehaviour(), getPedestrianLightBehaviour());
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting horizontal traffic ---\n");
                // Stop all vertical
                System.out.println("1. Stopping vertical traffic");
                crossing.stopAllVertical();

                // Start horizontal traffic
                System.out.println("\n2. Starting horizontal traffic");
                crossing.startHorizontalStraight();
                System.out.println("\n--- Horizontal traffic started!---\n");
            }
        }, 0, length);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting vertical traffic ---\n");

                System.out.println("1. Stopping horizontal traffic");
                crossing.stopAllHorizontal();

                System.out.println("\n2. Starting vertical traffic");
                crossing.startVerticalStraight();
                System.out.println("\n--- Vertical traffic started!---\n");
            }
        }, length/2, length);
    }

    @Override
    public void deactivate() {
        timer.cancel();
    }
}
