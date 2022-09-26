package frontend;

import frontend.controllers.*;
import interfaces.BusinessLogicAPI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class Simulation extends Application {
    private SceneManager sceneManager;
    private BusinessLogicAPI businessLogicAPI;
    private static final String INITIAL_VIEW = "simulationDashboard";

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {
        if (c.getName().equals("frontend.controllers.SimulationDashboardController")) {
            return new SimulationDashboardController(this::getSceneManager);
        }
        if (c.getName().equals("frontend.controllers.BasicCrossingSimulationController")) {
            return new BasicCrossingSimulationController(this::getSceneManager, businessLogicAPI.getBasicCrossingSimulationManager());
        }
        if (c.getName().equals("frontend.controllers.AdvancedCrossingSimulationController")) {
            return new AdvancedCrossingSimulationController(this::getSceneManager, businessLogicAPI.getAdvancedCrossingSimulationManager());
        }
        if (c.getName().equals("frontend.controllers.SinglePedestrianTrafficLightSimulationController")) {
            return new SinglePedestrianTrafficLightSimulationController(this::getSceneManager, businessLogicAPI.getPedestrianLightSimulationManager());
        }
        if (c.getName().equals("frontend.controllers.SingleStreetTrafficLightSimulationController")) {
            return new SingleStreetTrafficLightSimulationController(this::getSceneManager, businessLogicAPI.getStreetLightSimulationManager());
        }
        return null;

    };

    public Simulation(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    public Simulation show() {
        return init(true);
    }

    Simulation init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {
            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    /**
     * Initializes sceneManager.
     */
    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    /**
     * Action function for starting the GUI application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        sceneManager.displayOn(stage, 950, 800, "Simulation");
    }

    /**
     * Returns sceneManager.
     */
    public SceneManager getSceneManager() {
        return sceneManager;
    }
}

