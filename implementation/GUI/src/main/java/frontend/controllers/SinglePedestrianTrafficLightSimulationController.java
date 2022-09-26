package frontend.controllers;

import frontend.SceneManager;
import frontend.helpers.CircleShapeObserver;
import frontend.helpers.FXShapeLightObserver;
import interfaces.*;
import static frontend.helpers.ObservableListHelper.entitiesToObservableListDistinct;
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

public class SinglePedestrianTrafficLightSimulationController extends ControllerBase implements Initializable {
    Timer timer;

    Map<String, String> shapeToURLMap;
    boolean isSimulationStarted;
    private final PedestrianTrafficLightSimulationManager simulationManager;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public SinglePedestrianTrafficLightSimulationController(Supplier<SceneManager> sceneManager, PedestrianTrafficLightSimulationManager businessLogicAPI) {
        super(sceneManager);
        this.simulationManager = businessLogicAPI;
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

        shapeToURLMap.put("Dot Shape", "/frontend/shapes/dotShape.png");
        shapeToURLMap.put("Donkey Shape", "/frontend/shapes/donkeyShape.png");
        shapeToURLMap.put("Man Shape", "/frontend/shapes/manShape.png");

        shapeBox.setItems(entitiesToObservableListDistinct(simulationManager.getAllPedestrianShapesStrings()));

        behaviourBox.setItems(entitiesToObservableListDistinct(simulationManager.getAllPedestrianLightBehaviourStrings()));

        List<Integer> lengths = List.of(1, 2, 3, 4, 5);
        lengthBox.setItems(entitiesToObservableListDistinct(lengths));

        shapeBox.setValue("Dot Shape");
        behaviourBox.setValue("German Pedestrian Behaviour");
        lengthBox.setValue(5);

        simulationManager.addObserversToPedestrianTrafficLight(new FXShapeLightObserver(lightCircle), new CircleShapeObserver(innerCircle, shapeToURLMap));

        simulationManager.setShapeOfPedestrianTrafficLight("Dot Shape");

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
                        simulationManager.changeStateToNextForPedestrianTrafficLight();
                        stateField.setText(simulationManager.getNameOfCurrentStateOfPedestrianTrafficLight());
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
        simulationManager.setShapeOfPedestrianTrafficLight(shapeBox.getValue());
    }

    /**
     * Changes light behaviour of the current traffic light.
     */
    @FXML
    public void changeBehaviour() {
        if(isSimulationStarted) {
            endSimulation();
            simulationManager.setLightBehaviourOfPedestrianTrafficLight(behaviourBox.getValue());
            startSimulation();
        }
        else {
            simulationManager.setLightBehaviourOfPedestrianTrafficLight(behaviourBox.getValue());
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
