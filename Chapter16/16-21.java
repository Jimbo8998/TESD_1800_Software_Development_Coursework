import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {

    private static final String AUDIO_URL =
        "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";

    private Timeline timeline;
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) {
        TextField tfSeconds = new TextField();
        tfSeconds.setPromptText("Enter seconds and press Enter");
        tfSeconds.setPrefColumnCount(10);

        Label lbl = new Label("0");
        lbl.setMinWidth(220);
        lbl.setAlignment(Pos.CENTER);
        lbl.setStyle("-fx-font-size: 64px; -fx-font-weight: bold;");

        VBox root = new VBox(12, tfSeconds, lbl);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        tfSeconds.setOnAction(e -> {
            stopAll(); // stop any prior timer/music

            int s;
            try {
                s = Integer.parseInt(tfSeconds.getText().trim());
                if (s < 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                lbl.textProperty().unbind();
                lbl.setText("0");
                return;
            }

            IntegerProperty remaining = new SimpleIntegerProperty(s);
            lbl.textProperty().unbind();
            lbl.textProperty().bind(remaining.asString());

            timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
                int next = remaining.get() - 1;
                remaining.set(next);
                if (next <= 0) {
                    timeline.stop();
                    lbl.textProperty().unbind();
                    lbl.setText("0");
                    playMusicLoop();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        stage.setOnCloseRequest(e -> stopAll());

        stage.setTitle("Exercise 16-21");
        stage.setScene(new Scene(root, 340, 240));
        stage.show();
    }

    private void playMusicLoop() {
        mediaPlayer = new MediaPlayer(new Media(AUDIO_URL));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    private void stopAll() {
        if (timeline != null) timeline.stop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
