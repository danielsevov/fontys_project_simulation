package frontend.controllers;

import frontend.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
/**
 * Controller for Simulation Dashboard creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */
public class SimulationDashboardController extends ControllerBase implements Initializable{

    public SimulationDashboardController(Supplier<SceneManager> sceneManager) {
        super(sceneManager);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Closes application.
     */
    @FXML
    public void exit() {
        sceneManager.get().closeStage();
    }

    /**
     * Starts pedestrian traffic light simulation.
     */
    @FXML
    public void singlePedestrianTrafficLightSimulation() {
        sceneManager.get().changeScene("singlePedestrianTrafficLightSimulation");
    }

    /**
     * Starts traffic light simulation.
     */
    @FXML
    public void singleStreetTrafficLightSimulation() {
        sceneManager.get().changeScene("singleStreetTrafficLightSimulation");
    }

    /**
     * Starts simple crossing simulation.
     */
    @FXML
    public void simpleCrossingSimulation() {
        sceneManager.get().changeScene("basicCrossingSimulation");
    }

    /**
     * Starts advanced crossing simulation.
     */
    @FXML
    public void advancedCrossingSimulation() {
        sceneManager.get().changeScene("advancedCrossingSimulation");
    }
}
