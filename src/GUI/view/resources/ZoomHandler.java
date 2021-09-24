package GUI.view.resources;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ZoomHandler implements EventHandler<ScrollEvent> {
    private final ScrollPane scrollPane;
    private final Pane canvas;
    private final double minScale;
    private final double maxScale;
    public ZoomHandler(ScrollPane scrollPane, GridPane canvas, double minScale, double maxScale) {
        this.scrollPane = scrollPane;
        this.canvas = canvas;
        this.minScale = minScale;
        this.maxScale = maxScale; }
    public ZoomHandler(ScrollPane scrollPane, GridPane canvas) {
        this(scrollPane, canvas, 0.1, 10); }
    @Override public void handle(ScrollEvent e) {
        if (e.isControlDown()) { double actualScale = canvas.getScaleX();
            if (actualScale > maxScale || actualScale < minScale)
            { e.consume();
                return; }
            double hVal = scrollPane.getHvalue();
            double vVal = scrollPane.getVvalue();
            double scale, factor;
            if (e.getDeltaY() > 0)
            { factor = 1.1; }
            else { factor = 0.9; }
            scale = actualScale * factor;
            scale = Math.min(scale, maxScale);
            scale = Math.max(scale, minScale);
            canvas.setScaleX(scale);
            canvas.setScaleY(scale);
            scrollPane.setHvalue(hVal);
            scrollPane.setVvalue(vVal);
            e.consume();
        }
    } }