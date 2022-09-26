package pedestrianLightBehaviours;

import interfaces.PedestrianLightState;

public enum AustralianPedestrianLightBehaviour  implements PedestrianLightState {

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
            return RED_BLINKING_LIGHT;
        }

    },

    RED_BLINKING_LIGHT(LightStateMeaning.TRANSITION, "Red Blinking Light"){
        @Override
        public String getColorHex() {
            return "#6c0000";
        }

        @Override
        public PedestrianLightState getNext() {
            return RED_LIGHT;
        }

    };

    private final LightStateMeaning stateMeaning;
    private final String name;

    AustralianPedestrianLightBehaviour (LightStateMeaning stateMeaning, String name) {
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
