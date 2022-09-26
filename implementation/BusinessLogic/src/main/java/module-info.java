module businesslogic_module {
    requires transitive interfaces_module;
    opens streetLightBehaviours;
    opens pedestrianLightBehaviours;
    opens trafficLights;
    opens shapes;
    opens crossings;
    opens businessLogic;
    opens crossingModes;
    exports trafficLights;
    exports streetLightBehaviours;
    exports pedestrianLightBehaviours;
    exports shapes;
    exports crossings;
    exports factories;
    exports businessLogic;
    exports crossingModes;
}