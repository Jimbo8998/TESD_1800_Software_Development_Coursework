import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PentagonAnimation extends Application {
    private static final double WIDTH = 450;
    private static final double HEIGHT = 450;

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        // Pentagon outline
        Polygon pentagon = makeRegularPentagon(WIDTH / 2, HEIGHT / 2, 160);
        pentagon.setFill(Color.TRANSPARENT);
        pentagon.setStroke(Color.BLACK);

        // Moving rectangle
        Rectangle rect = new Rectangle(24, 12, Color.CRIMSON);
        rect.setArcWidth(4);
        rect.setArcHeight(4);

        // Path from pentagon perimeter
        Path perimeter = polygonToPath(pentagon);

        // Movement along the path
        PathTransition move = new PathTransition(Duration.seconds(6), perimeter, rect);
        move.setCycleCount(PathTransition.INDEFINITE);
        move.setAutoReverse(false);
        // Optional: uncomment to rotate with path
        // move.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        // Opacity change while moving
        FadeTransition fade = new FadeTransition(Duration.seconds(2.5), rect);
        fade.setFromValue(1.0);
        fade.setToValue(0.25);
        fade.setAutoReverse(true);
        fade.setCycleCount(FadeTransition.INDEFINITE);

        move.play();
        fade.play();

        // Mouse: left = pause, right = resume
        root.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                move.pause();
                fade.pause();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                move.play();
                fade.play();
            }
        });

        root.getChildren().addAll(pentagon, rect);
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.setTitle("Rectangle on Pentagon");
        stage.show();
    }

    private static Polygon makeRegularPentagon(double cx, double cy, double r) {
        Polygon p = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = -Math.PI / 2 + i * 2 * Math.PI / 5; // start at top
            p.getPoints().addAll(cx + r * Math.cos(angle), cy + r * Math.sin(angle));
        }
        return p;
    }

    private static Path polygonToPath(Polygon poly) {
        Path path = new Path();
        var pts = poly.getPoints();
        path.getElements().add(new MoveTo(pts.get(0), pts.get(1)));
        for (int i = 2; i < pts.size(); i += 2) {
            path.getElements().add(new LineTo(pts.get(i), pts.get(i + 1)));
        }
        path.getElements().add(new ClosePath());
        return path;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
