package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.FXShapeLightObserver;
import interfaces.BasicCrossingSimulationManager;
import interfaces.BusinessLogicAPI;
import interfaces.LightObserver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;

/**
 * Controller for Simple Crossing Simulation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */
public class BasicCrossingSimulationController extends ControllerBase implements Initializable{
    BasicCrossingSimulationManager simulationManager;
    boolean isActive;

    @FXML
    Circle horizontalCircle1, horizontalCircle2, horizontalCircle3, horizontalCircle4,
            verticalCircle1, verticalCircle2, verticalCircle3, verticalCircle4;

    @FXML
    Rectangle horizontalRectangle1, horizontalRectangle2, verticalRectangle1, verticalRectangle2,
            innerHorizontalRectangle1, innerHorizontalRectangle2, innerVerticalRectangle1, innerVerticalRectangle2;

    @FXML
    ComboBox<Integer> lengthBox;

    public BasicCrossingSimulationController(Supplier<SceneManager> sceneManager, BasicCrossingSimulationManager manager) {
        super(sceneManager);
        this.simulationManager = manager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isActive = false;
        resetLights();
        List<LightObserver> horizontalPedestrian = List.of(
                new FXShapeLightObserver(horizontalCircle1),
                new FXShapeLightObserver(horizontalCircle2),
                new FXShapeLightObserver(horizontalCircle3),
                new FXShapeLightObserver(horizontalCircle4));

        List<LightObserver> verticalPedestrian = List.of(
                new FXShapeLightObserver(verticalCircle1),
                new FXShapeLightObserver(verticalCircle2),
                new FXShapeLightObserver(verticalCircle3),
                new FXShapeLightObserver(verticalCircle4));

        List<LightObserver> horizontalStreet = List.of(
                new FXShapeLightObserver(horizontalRectangle1),
                new FXShapeLightObserver(horizontalRectangle2));

        List<LightObserver> verticalStreet = List.of(
                new FXShapeLightObserver(verticalRectangle1),
                new FXShapeLightObserver(verticalRectangle2));

        simulationManager.addObserversToBasicCrossing(horizontalPedestrian, verticalPedestrian, horizontalStreet, verticalStreet);

        innerHorizontalRectangle1.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowRight.png").toExternalForm())));
        innerHorizontalRectangle2.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowLeft.png").toExternalForm())));
        innerVerticalRectangle1.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowBackward.png").toExternalForm())));
        innerVerticalRectangle2.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowForward.png").toExternalForm())));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        lengthBox.setValue(5);
    }

    private void resetLights(){
        horizontalRectangle1.setStroke(Paint.valueOf("white"));
        horizontalRectangle2.setStroke(Paint.valueOf("white"));
        verticalRectangle1.setStroke(Paint.valueOf("white"));
        verticalRectangle2.setStroke(Paint.valueOf("white"));

        changeColorOfAllLights("black");
    }
    
    private void changeColorOfAllLights(String colorCode){
        horizontalCircle1.setFill(Paint.valueOf(colorCode));
        horizontalCircle2.setFill(Paint.valueOf(colorCode));
        horizontalCircle3.setFill(Paint.valueOf(colorCode));
        horizontalCircle4.setFill(Paint.valueOf(colorCode));

        verticalCircle1.setFill(Paint.valueOf(colorCode));
        verticalCircle2.setFill(Paint.valueOf(colorCode));
        verticalCircle3.setFill(Paint.valueOf(colorCode));
        verticalCircle4.setFill(Paint.valueOf(colorCode));

        horizontalRectangle1.setFill(Paint.valueOf(colorCode));
        horizontalRectangle2.setFill(Paint.valueOf(colorCode));

        verticalRectangle1.setFill(Paint.valueOf(colorCode));
        verticalRectangle2.setFill(Paint.valueOf(colorCode));
    }

    /**
     * Closes simulation.
     */
    @FXML
    public void exit() {
        endSimulation();
        sceneManager.get().changeScene("simulationDashboard");
    }

    /**
     * Starts simulation.
     */
    @FXML
    public void startSimulation() {
        if(!isActive) {
            changeColorOfAllLights("red");
            simulationManager.activateBasicCrossing(lengthBox.getValue() * 1000);
            isActive = true;
        }
    }

    /**
     * Ends simulation.
     */
    @FXML
    public void endSimulation() {
        if(isActive){
            simulationManager.deactivateBasicCrossing();
            resetLights();
            isActive = false;
        }
    }

    /**
     * Changes length of the light signal.
     */
    @FXML
    public void changeLength() {
        if(isActive) {
            endSimulation();
            startSimulation();
        }
    }
}
