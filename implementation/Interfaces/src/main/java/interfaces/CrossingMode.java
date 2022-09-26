package interfaces;

public interface CrossingMode {
    /**
     * Activates crossing logic loop.
     *
     */
    void activate(Crossing crossing, int length);

    /**
     * Deactivates crossing logic loop.
     *
     */
    void deactivate();

    StreetLightState getStreetLightBehaviour();

    PedestrianLightState getPedestrianLightBehaviour();
}
