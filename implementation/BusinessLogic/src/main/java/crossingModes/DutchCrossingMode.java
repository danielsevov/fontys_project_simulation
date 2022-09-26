package crossingModes;

import interfaces.Crossing;
import interfaces.CrossingMode;
import interfaces.PedestrianLightState;
import interfaces.StreetLightState;
import pedestrianLightBehaviours.DutchPedestrianLightBehaviour;
import streetLightBehaviours.DutchStreetLightBehaviour;

import java.util.Timer;
import java.util.TimerTask;

public class DutchCrossingMode implements CrossingMode {
    Timer timer;

    public DutchCrossingMode() {
        resetTimer();
    }

    private void resetTimer(){
        timer = new Timer();
    }

    // Used for tests
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void activate(Crossing crossing, int length) {
        // Make sure that the crossing is on the correct mode.
        crossing.changeLightBehaviour(getStreetLightBehaviour(), getPedestrianLightBehaviour());

        // Change states
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting horizontal traffic ---\n");
                // Stop all vertical
                System.out.println("1. Stopping vertical traffic");
                crossing.stopAllVertical();

                // Start horizontal straight
                System.out.println("\n2. Starting horizontal straight traffic");
                crossing.startHorizontalStraight();
            }
        }, 0, length * 3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // Stop pedestrian horizontal
                System.out.println("\n3. Starting horizontal right traffic");
                crossing.startHorizontalRight();
            }
        }, length/2, length* 3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n4. Starting horizontal right traffic");
                crossing.stopAllHorizontal();
                crossing.startHorizontalLeft();

                System.out.println("\n--- Horizontal traffic started!---\n");
            }
        }, length, length* 3L);


        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting vertical traffic ---\n");
                System.out.println("1. Stopping horizontal traffic");
                crossing.stopAllHorizontal();

                System.out.println("\n2. Starting vertical straight traffic");
                crossing.startVerticalStraight();
            }
        }, length + length/2, length*3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // Stop pedestrian horizontal
                System.out.println("\n3. Starting vertical right traffic");
                crossing.startVerticalRight();
            }
        }, length* 2L, length*3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n4. Starting vertical right traffic");
                crossing.stopAllVertical();
                crossing.startVerticalLeft();

                System.out.println("\n--- Vertical traffic started!---\n");
            }
        }, length*2L + length/2, length*3L);
    }

    @Override
    public void deactivate() {
        timer.cancel();
    }

    @Override
    public StreetLightState getStreetLightBehaviour() {
        return DutchStreetLightBehaviour.RED_LIGHT;
    }

    @Override
    public PedestrianLightState getPedestrianLightBehaviour() {
        return DutchPedestrianLightBehaviour.RED_LIGHT;
    }
}
