package streetLightBehaviours;

import interfaces.StreetLightState;

public enum EmergencyStreetLightBehaviour implements StreetLightState {
    YELLOW_BLINKING_LIGHT(LightStateMeaning.PASS, "Emergency Light"){
        @Override
        public String getColorHex() {
            return "#F77910";
        }

        @Override
        public StreetLightState getNext() {
            return NO_LIGHT;
        }

    },

    NO_LIGHT(LightStateMeaning.STOP, "Emergency Light"){
        @Override
        public String getColorHex() {
            return "#000000";
        }

        @Override
        public StreetLightState getNext() {
            return YELLOW_BLINKING_LIGHT ;
        }

    };

    private final LightStateMeaning stateMeaning;
    private final String name;

    EmergencyStreetLightBehaviour (LightStateMeaning stateMeaning, String name) {
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

