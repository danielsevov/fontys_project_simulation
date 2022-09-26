package streetLightBehaviours;

import interfaces.StreetLightState;

public enum GermanStreetLightBehaviour implements StreetLightState {

    RED_LIGHT(LightStateMeaning.STOP, "Red Light"){
        @Override
        public String getColorHex() {
            return "#EE0000";
        }

        @Override
        public StreetLightState getNext() {
            return RED_YELLOW;
        }

    },

    GREEN_LIGHT(LightStateMeaning.PASS, "Green Light"){
        @Override
        public String getColorHex() {
            return "#00FF12";
        }

        @Override
        public StreetLightState getNext() {
            return YELLOW;
        }

    },

    RED_YELLOW(LightStateMeaning.TRANSITION, "Red Yellow Light"){
        @Override
        public String getColorHex() {
            return "#9c6500";
        }

        @Override
        public StreetLightState getNext() {
            return GREEN_LIGHT;
        }

    },
    YELLOW(LightStateMeaning.TRANSITION, "Yellow Light"){
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

    GermanStreetLightBehaviour (LightStateMeaning stateMeaning, String name) {
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

