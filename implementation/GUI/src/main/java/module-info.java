module GUI_module {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires interfaces_module;
    requires transitive businesslogic_module;
    requires java.logging;
    requires tornadofx.controls;

    opens frontend to javafx.fxml;
    opens frontend.controllers to javafx.fxml;
    exports frontend;
    exports frontend.controllers;
    exports frontend.helpers;
    opens frontend.helpers to javafx.fxml;
}