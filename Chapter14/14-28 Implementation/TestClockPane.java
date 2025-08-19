import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;

public class TestClockPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Generate random Hour (0-11)
        int hour = ThreadLocalRandom.current().nextInt(0, 12);
        // Generate random Minute (0 or 30)
        int minute = ThreadLocalRandom.current().nextBoolean() ? 0 : 30;
        // Generate random Second (0-59)
        int second = 0; // Always 0 for this test

        // Create clock with random time
        ClockPane clock = new ClockPane(hour, minute, second);

        // Only show Hour and Minute hands
        clock.setHourHandVisible(true);
        clock.setMinuteHandVisible(true);
        clock.setSecondHandVisible(false);

        // Show Window
        Scene scene = new Scene(clock, 300, 300);
        primaryStage.setTitle("Test ClockPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
