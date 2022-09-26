package frontend.controllers;

import frontend.SceneManager;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.function.Supplier;

/**
 * Controller base for all JavaFx controllers.
 */
public abstract class ControllerBase {
    final Supplier<SceneManager> sceneManager;

    protected ControllerBase(Supplier<SceneManager> sceneManager) {
        this.sceneManager = sceneManager;
    }

    /**
     * Creates a TableColumn.
     */
    <T> TableColumn<T, String> makeColumn(String name, String title, double width) {
        TableColumn<T, String> make = new TableColumn<>(title);
        make.setPrefWidth(width);
        make.setStyle("-fx-alignment: CENTER;");
        make.setCellValueFactory(new PropertyValueFactory<>(name));
        return make;
    }
}
