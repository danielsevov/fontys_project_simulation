package pedestrianLightBehaviours;

import interfaces.PedestrianLightState;

/**
 * Light behaviour for german pedestrian traffic lights
 *
 */
public enum BulgarianPedestrianLightBehaviour implements PedestrianLightState {

    RED_LIGHT(LightStateMeaning.STOP, "Red Light"){
        @Override
        public String getColorHex() {
            return "#EE0000";
        }

        @Override
        public PedestrianLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(LightStateMeaning.PASS, "Green Light"){
        @Override
        public String getColorHex() {
            return "#00FF12";
        }

        @Override
        public PedestrianLightState getNext() {
            return GREEN_BLINKING_LIGHT;
        }

    },

    GREEN_BLINKING_LIGHT(LightStateMeaning.TRANSITION, "Green Blinking Light"){
        @Override
        public String getColorHex() {
            return "#006412";
        }

        @Override
        public PedestrianLightState getNext() {
            return RED_LIGHT;
        }

    };


    private final LightStateMeaning stateMeaning;
    private final String name;

    BulgarianPedestrianLightBehaviour (LightStateMeaning stateMeaning, String name) {
        this.stateMeaning = stateMeaning;
        this.name = name;
    }

    @Override
    public LightStateMeaning stateMeaning() {
        return stateMeaning;
    }

    @Override
    public String getName() {
        return name;
    }
}
