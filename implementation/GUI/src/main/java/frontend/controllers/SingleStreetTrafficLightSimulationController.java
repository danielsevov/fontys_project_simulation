package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.CircleShapeObserver;
import frontend.helpers.FXShapeLightObserver;
import interfaces.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;

public class SingleStreetTrafficLightSimulationController extends ControllerBase implements Initializable {
    Timer timer;
    Map<String, String> shapeToURLMap;
    boolean isSimulationStarted;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final StreetTrafficLightSimulationManager simulationManager;

    public SingleStreetTrafficLightSimulationController(Supplier<SceneManager> sceneManager, StreetTrafficLightSimulationManager manager) {
        super(sceneManager);
        this.simulationManager = manager;
        shapeToURLMap = new HashMap<>();
        isSimulationStarted = false;
        resetTimer();
        }

    @FXML
    Circle lightCircle, innerCircle;

    @FXML
    ComboBox<String> behaviourBox, shapeBox;

    @FXML
    ComboBox<Integer> lengthBox;

    @FXML
    TextField stateField;

    @FXML
    TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetLight();

        shapeToURLMap.put("Arrow Forward Shape", "/frontend/shapes/arrowForward.png");
        shapeToURLMap.put("Arrow Left Shape", "/frontend/shapes/arrowLeft.png");
        shapeToURLMap.put("Arrow Right Shape", "/frontend/shapes/arrowRight.png");

        shapeBox.setItems(entitiesToObservableListDistinct(simulationManager.getAllStreetShapesStrings()));

        behaviourBox.setItems(entitiesToObservableListDistinct(simulationManager.getAllStreetLightBehaviourStrings()));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        shapeBox.setValue("Arrow Forward Shape");
        behaviourBox.setValue("German Street Behaviour");
        lengthBox.setValue(5);

        simulationManager.addObserversToStreetTrafficLight(new FXShapeLightObserver(lightCircle), new CircleShapeObserver(innerCircle, shapeToURLMap));

        simulationManager.setShapeOfStreetTrafficLight("Arrow Forward Shape");

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private void resetLight(){
        lightCircle.setFill(Paint.valueOf("black"));
        lightCircle.setStroke(Paint.valueOf("white"));
        stateField.clear();
    }

    /**
     * Closes simulation.
     */
    @FXML
    public void exit() {
        endSimulation();
        sceneManager.get().changeScene("simulationDashboard");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    /**
     * Starts simulation.
     */
    @FXML
    public void startSimulation() {
        resetTimer();
        System.setOut(new PrintStream(outputStreamCaptor));
        if(!isSimulationStarted){
            isSimulationStarted = true;
            timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        simulationManager.changeStateToNextForStreetTrafficLight();
                        stateField.setText(simulationManager.getNameOfCurrentStateOfStreetTrafficLight());
                        textArea.setText(outputStreamCaptor.toString());
                        textArea.appendText("\n");
                    }
                }, 0, lengthBox.getValue() * 1000);
        }
    }

    /**
     * Resets timer.
     */
    private void resetTimer() {
        timer = new Timer();
    }

    /**
     * Ends simulation.
     */
    @FXML
    public void endSimulation() {
        isSimulationStarted = false;
        timer.cancel();
        resetLight();
        outputStreamCaptor.reset();
        textArea.clear();
    }

    /**
     * Changes shape of the current traffic light.
     */
    @FXML
    public void changeShape() {
        simulationManager.setShapeOfStreetTrafficLight(shapeBox.getValue());
    }

    /**
     * Changes light behaviour of the current traffic light.
     */
    @FXML
    public void changeBehaviour() {
        if(isSimulationStarted) {
            endSimulation();
            simulationManager.setLightBehaviourOfStreetTrafficLight(behaviourBox.getValue());
            startSimulation();
        }
        else {
            simulationManager.setLightBehaviourOfStreetTrafficLight(behaviourBox.getValue());
        }
    }

    /**
     * Changes length of the light signal.
     */
    @FXML
    public void changeLength() {
        if(isSimulationStarted) {
            endSimulation();
            startSimulation();
        }
    }
}
