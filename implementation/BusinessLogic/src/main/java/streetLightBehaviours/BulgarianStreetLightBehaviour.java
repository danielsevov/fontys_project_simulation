package streetLightBehaviours;

import interfaces.StreetLightState;

/**
 * Light behaviour for simple street traffic lights
 *
 */
public enum BulgarianStreetLightBehaviour implements StreetLightState {

    RED_LIGHT(LightStateMeaning.STOP, "Red Light"){
        @Override
        public String getColorHex() {
            return "#EE0000";
        }

        @Override
        public StreetLightState getNext() {
            return YELLOW_LIGHT_BEFORE_GREEN;
        }

    },

    YELLOW_LIGHT_BEFORE_GREEN(LightStateMeaning.TRANSITION, "Yellow Light"){
        @Override
        public String getColorHex() {
            return "#FFFE00";
        }

        @Override
        public StreetLightState getNext() {
            return GREEN_LIGHT;
        }

    },

    GREEN_LIGHT(LightStateMeaning.PASS, "Green Light"){
        @Override
        public String getColorHex() {
            return "#00FF12";
        }

        @Override
        public StreetLightState getNext() {
            return YELLOW_LIGHT_AFTER_GREEN;
        }

    },

    YELLOW_LIGHT_AFTER_GREEN(LightStateMeaning.TRANSITION, "Yellow Light"){
        @Override
        public String getColorHex() {
            return "#FFFE00";
        }

        @Override
        public StreetLightState getNext() {
            return RED_LIGHT;
        }

    };


    private final LightStateMeaning stateMeaning;
    private final String name;

    BulgarianStreetLightBehaviour (LightStateMeaning stateMeaning, String name) {
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
