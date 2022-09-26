package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.FXShapeLightObserver;
import interfaces.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;

/**
 * Controller for Advanced Crossing Simulation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */
public class AdvancedCrossingSimulationController extends ControllerBase implements Initializable{
    AdvancedCrossingSimulationManager simulationManager;
    boolean isActive;

    @FXML
    Circle horizontalCircle1, horizontalCircle2, horizontalCircle3, horizontalCircle4,
            verticalCircle1, verticalCircle2, verticalCircle3, verticalCircle4;

    //horizontalRectangle1 = left side
    //horizontalRectangle2 = right side
    //verticalRectangle1 = top side
    //verticalRectangle2 = bottom side
    @FXML
    Rectangle horizontalRectangle1Straight, innerHorizontalRectangle1Straight,
            horizontalRectangle1Left, innerHorizontalRectangle1Left,
            horizontalRectangle1Right, innerHorizontalRectangle1Right,

            horizontalRectangle2Straight, innerHorizontalRectangle2Straight,
            horizontalRectangle2Left, innerHorizontalRectangle2Left,
            horizontalRectangle2Right, innerHorizontalRectangle2Right,

            verticalRectangle1Straight, innerVerticalRectangle1Straight,
            verticalRectangle1Left, innerVerticalRectangle1Left,
            verticalRectangle1Right, innerVerticalRectangle1Right,

            verticalRectangle2Straight, innerVerticalRectangle2Straight,
            verticalRectangle2Left, innerVerticalRectangle2Left,
            verticalRectangle2Right, innerVerticalRectangle2Right;

    @FXML
    ComboBox<Integer> lengthBox;

    @FXML
    ComboBox<String> modeBox;

    public AdvancedCrossingSimulationController(Supplier<SceneManager> sceneManager, AdvancedCrossingSimulationManager manager) {
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

        List<LightObserver> horizontalStreetStraight = List.of(
                new FXShapeLightObserver(horizontalRectangle1Straight),
                new FXShapeLightObserver(horizontalRectangle2Straight));

        List<LightObserver> verticalStreetStraight = List.of(
                new FXShapeLightObserver(verticalRectangle1Straight),
                new FXShapeLightObserver(verticalRectangle2Straight));

        List<LightObserver> horizontalStreetLeft = List.of(
                new FXShapeLightObserver(horizontalRectangle1Left),
                new FXShapeLightObserver(horizontalRectangle2Left));

        List<LightObserver> verticalStreetLeft = List.of(
                new FXShapeLightObserver(verticalRectangle1Left),
                new FXShapeLightObserver(verticalRectangle2Left));

        List<LightObserver> horizontalStreetRight = List.of(
                new FXShapeLightObserver(horizontalRectangle1Right),
                new FXShapeLightObserver(horizontalRectangle2Right));

        List<LightObserver> verticalStreetRight = List.of(
                new FXShapeLightObserver(verticalRectangle1Right),
                new FXShapeLightObserver(verticalRectangle2Right));

        simulationManager.addObserversToAdvancedCrossing(horizontalPedestrian, verticalPedestrian, horizontalStreetStraight, verticalStreetStraight, horizontalStreetLeft, verticalStreetLeft, horizontalStreetRight, verticalStreetRight);

        innerHorizontalRectangle1Straight.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowRight.png").toExternalForm())));
        innerHorizontalRectangle1Left.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowForward.png").toExternalForm())));
        innerHorizontalRectangle1Right.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowBackward.png").toExternalForm())));

        innerHorizontalRectangle2Straight.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowLeft.png").toExternalForm())));
        innerHorizontalRectangle2Left.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowBackward.png").toExternalForm())));
        innerHorizontalRectangle2Right.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowForward.png").toExternalForm())));

        innerVerticalRectangle1Straight.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowBackward.png").toExternalForm())));
        innerVerticalRectangle1Left.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowRight.png").toExternalForm())));
        innerVerticalRectangle1Right.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowLeft.png").toExternalForm())));

        innerVerticalRectangle2Straight.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowForward.png").toExternalForm())));
        innerVerticalRectangle2Left.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowLeft.png").toExternalForm())));
        innerVerticalRectangle2Right.setFill(new ImagePattern(new Image(getClass().getResource("/frontend/shapes/arrowRight.png").toExternalForm())));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        lengthBox.setValue(5);

        modeBox.setItems(entitiesToObservableListDistinct(simulationManager.getAllCrossingModesStrings()));

        modeBox.setValue("German Crossing Mode");
    }

    private void resetLights(){
        changeStrokeOfAllLights("white");
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

        horizontalRectangle1Straight.setFill(Paint.valueOf(colorCode));
        horizontalRectangle1Left.setFill(Paint.valueOf(colorCode));
        horizontalRectangle1Right.setFill(Paint.valueOf(colorCode));

        horizontalRectangle2Straight.setFill(Paint.valueOf(colorCode));
        horizontalRectangle2Right.setFill(Paint.valueOf(colorCode));
        horizontalRectangle2Left.setFill(Paint.valueOf(colorCode));

        verticalRectangle1Straight.setFill(Paint.valueOf(colorCode));
        verticalRectangle1Right.setFill(Paint.valueOf(colorCode));
        verticalRectangle1Left.setFill(Paint.valueOf(colorCode));

        verticalRectangle2Straight.setFill(Paint.valueOf(colorCode));
        verticalRectangle2Right.setFill(Paint.valueOf(colorCode));
        verticalRectangle2Left.setFill(Paint.valueOf(colorCode));
    }

    private void changeStrokeOfAllLights(String colorCode){
        horizontalRectangle1Straight.setStroke(Paint.valueOf(colorCode));
        horizontalRectangle1Right.setStroke(Paint.valueOf(colorCode));
        horizontalRectangle1Left.setStroke(Paint.valueOf(colorCode));

        horizontalRectangle2Straight.setStroke(Paint.valueOf(colorCode));
        horizontalRectangle2Right.setStroke(Paint.valueOf(colorCode));
        horizontalRectangle2Left.setStroke(Paint.valueOf(colorCode));

        verticalRectangle1Straight.setStroke(Paint.valueOf(colorCode));
        verticalRectangle1Left.setStroke(Paint.valueOf(colorCode));
        verticalRectangle1Right.setStroke(Paint.valueOf(colorCode));

        verticalRectangle2Straight.setStroke(Paint.valueOf(colorCode));
        verticalRectangle2Right.setStroke(Paint.valueOf(colorCode));
        verticalRectangle2Left.setStroke(Paint.valueOf(colorCode));
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
            simulationManager.activateAdvancedCrossing(lengthBox.getValue() * 1000);
            isActive = true;
        }
    }

    /**
     * Ends simulation.
     */
    @FXML
    public void endSimulation() {
        if(isActive){
            simulationManager.deactivateAdvancedCrossing();
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

    /**
     * Changes mode of the crossing.
     */
    @FXML
    public void changeMode() {
        if(isActive) {
            endSimulation();
            simulationManager.setAdvancedCrossingMode(modeBox.getValue());
            startSimulation();
        }
        else simulationManager.setAdvancedCrossingMode(modeBox.getValue());
    }
}
