package frontend.helpers;

import interfaces.Shape;
import interfaces.ShapeObserver;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Map;

public class CircleShapeObserver implements ShapeObserver {
    private final Circle circle;
    private final Map<String, String> shapeToURLMap;

    public CircleShapeObserver(Circle circle, Map<String, String> shapeToURLMap){
        this.circle = circle;
        this.shapeToURLMap = shapeToURLMap;
    }
    @Override
    public void update(Shape newShape) {
        circle.setFill(new ImagePattern(new Image(getClass().getResource(shapeToURLMap.get(newShape.getName())).toExternalForm())));
    }
}
