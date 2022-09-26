package interfaces;

/**
 * Interface for LightState
 *
 */
public interface LightState {
    /**
     * Returns boolean indicating whether signal allows passing
     *
     */
    LightStateMeaning stateMeaning();

    /**
     * Returns name of the signal
     *
     */
    String getName();

    enum LightStateMeaning {
        PASS,
        STOP,
        TRANSITION
    }

    /**
     * Returns hex code of the signal color.
     *
     */
    String getColorHex();
}
