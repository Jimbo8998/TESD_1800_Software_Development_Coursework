import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_1 extends Application {
    private static final double STEP = 10;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Center: Message on a pane so we can clamp its X within bounds
        Pane canvas = new Pane();
        canvas.setPrefSize(520, 260);

        Text msg = new Text("Programming is fun!");
        msg.setFill(Color.BLACK);
        msg.setX(40);
        msg.setY(130); // baseline
        canvas.getChildren().add(msg);
        root.setCenter(canvas);

        // Top: Color radio buttons
        ToggleGroup group = new ToggleGroup();
        RadioButton rbRed = colorButton("Red", Color.RED, group, msg);
        RadioButton rbYellow = colorButton("Yellow", Color.YELLOW, group, msg);
        RadioButton rbBlack = colorButton("Black", Color.BLACK, group, msg);
        RadioButton rbOrange = colorButton("Orange", Color.ORANGE, group, msg);
        RadioButton rbGreen = colorButton("Green", Color.GREEN, group, msg);
        rbBlack.setSelected(true);

        HBox top = new HBox(12, rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(8));
        root.setTop(top);

        // Bottom: Step buttons
        Button left = new Button("<=");
        Button right = new Button("=>");
        left.setOnAction(e -> moveLeft(msg, canvas));
        right.setOnAction(e -> moveRight(msg, canvas));

        HBox bottom = new HBox(20, left, right);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(8));
        root.setBottom(bottom);

        // Optional: Arrow Keys also move the text
        root.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT -> moveLeft(msg, canvas);
                case RIGHT -> moveLeft(msg, canvas);
            }
        });

        Scene scene = new Scene(root, 620, 360);
        stage.setTitle("Ex16_1");
        stage.setScene(scene);
        stage.show();

        // Give root focus so arrow keys work immediately
        root.requestFocus();
    }

    private static RadioButton colorButton(String label, Color color, ToggleGroup group, Text target) {
        RadioButton rb = new RadioButton(label);
        rb.setToggleGroup(group);
        rb.setOnAction(e -> target.setFill(color));
        return rb;
    }

    private static void moveLeft(Text msg, Pane canvas) {
        double maxX = Math.max(0, canvas.getWidth() - msg.getLayoutBounds().getWidth());
        msg.setX(Math.min(maxX, msg.getX() - STEP));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
