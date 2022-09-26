package frontend.helpers;

import interfaces.LightState;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FXShapeLightObserver implements interfaces.LightObserver {
    private final Shape shape;

    public FXShapeLightObserver(Shape rec){
        this.shape = rec;
    }
    @Override
    public void update(LightState state) {
        shape.setFill(Paint.valueOf(state.getColorHex()));
    }
}
