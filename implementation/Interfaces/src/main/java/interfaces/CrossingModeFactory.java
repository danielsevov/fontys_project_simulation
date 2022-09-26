package interfaces;

import java.util.List;

public interface CrossingModeFactory {
    /**
     * Creates a crossing with simple crossing logic (Controls only the two main street traffic lights).
     *
     */
    CrossingMode createSimpleCrossingMode();

    /**
     * Creates a crossing with german crossing logic (Controls all street traffic lights).
     * This mode is the normal working mode for all german crossings.
     *
     */
    CrossingMode createGermanCrossingMode();

    CrossingMode createEmergencyCrossingMode();

    CrossingMode createDutchCrossingMode();

    CrossingMode createBulgarianCrossingMode();

    List<CrossingMode> getAllCrossingModes();
}
