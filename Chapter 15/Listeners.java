import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Listeners extends Application {

    @Override
    public void start(Stage stage) {
        MoveBallPane ballPane = new MoveBallPane();

        Button left  = new Button("Left");
        Button right = new Button("Right");
        Button up    = new Button("Up");
        Button down  = new Button("Down");

        left.setOnAction(e  -> ballPane.moveLeft());
        right.setOnAction(e -> ballPane.moveRight());
        up.setOnAction(e    -> ballPane.moveUp());
        down.setOnAction(e  -> ballPane.moveDown());

        HBox controls = new HBox(10, left, right, up, down);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(8));

        BorderPane root = new BorderPane();
        root.setCenter(ballPane);
        root.setBottom(controls);

        Scene scene = new Scene(root, 420, 320);
        stage.setTitle("Exercise15_03");
        stage.setScene(scene);
        stage.show();
    }

    // Pane class that draws and moves the ball
    static class MoveBallPane extends Pane {
        private final Circle ball = new Circle(15);
        private static final double STEP = 50;

        MoveBallPane() {
            setPrefSize(360, 240);
            ball.setStroke(Color.BLACK);
            ball.setFill(Color.TRANSPARENT);
            // Safe starting position
            ball.setCenterX(40);
            ball.setCenterY(80);
            getChildren().add(ball);

            // Keep the ball inside if the window is resized
            widthProperty().addListener((o, a, b) -> clampInside());
            heightProperty().addListener((o, a, b) -> clampInside());
        }

        void moveLeft() {
            double r = ball.getRadius();
            double nx = ball.getCenterX() - STEP;
            ball.setCenterX(Math.max(r, nx));
        }

        void moveRight() {
            double r = ball.getRadius();
            double limit = Math.max(r, getWidth() - r);
            double nx = ball.getCenterX() + STEP;
            ball.setCenterX(Math.min(limit, nx));
        }

        void moveUp() {
            double r = ball.getRadius();
            double ny = ball.getCenterY() - STEP;
            ball.setCenterY(Math.max(r, ny));
        }

        void moveDown() {
            double r = ball.getRadius();
            double limit = Math.max(r, getHeight() - r);
            double ny = ball.getCenterY() + STEP;
            ball.setCenterY(Math.min(limit, ny));
        }

        // Ensures the ball never sits outside the visible pane
        private void clampInside() {
            double r = ball.getRadius();
            double w = getWidth();
            double h = getHeight();
            if (w <= 0 || h <= 0) return;

            ball.setCenterX(Math.min(Math.max(ball.getCenterX(), r), w - r));
            ball.setCenterY(Math.min(Math.max(ball.getCenterY(), r), h - r));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
