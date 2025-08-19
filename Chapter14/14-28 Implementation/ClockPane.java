import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    //Visible Properties
    private final BooleanProperty hourHandVisible = new SimpleBooleanProperty(true);
    private final BooleanProperty minuteHandVisible = new SimpleBooleanProperty(true);
    private final BooleanProperty secondHandVisible = new SimpleBooleanProperty(true);
    
    public ClockPane(int hour, int minute, int second) {
        setTime(hour, minute, second);
    widthProperty().addListener((obs, o, n) -> paintClock());
    heightProperty().addListener((obs, o, n) -> paintClock());
    hourHandVisible.addListener((obs, o, n) -> paintClock());
    minuteHandVisible.addListener((obs, o, n) -> paintClock());
    secondHandVisible.addListener((obs, o, n) -> paintClock());
    paintClock();
    }

    //Set Time 
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public int getHour() {return hour; }
    public int getMinute() {return minute; }
    public int getSecond() {return second; }

    // Visible Properties(getters/Settters)
    public boolean isHourHandVisible() { return hourHandVisible.get(); }
    public void setHourHandVisible(boolean value) { hourHandVisible.set(value); }

    public boolean isMinuteHandVisible() { return minuteHandVisible.get(); }
    public void setMinuteHandVisible(boolean value) { minuteHandVisible.set(value); }

    public boolean isSecondHandVisible() { return secondHandVisible.get(); }
    public void setSecondHandVisible(boolean value) { secondHandVisible.set(value); }

    //Draw Clock
    private void paintClock() {
        getChildren().clear();

        double w = getWidth() > 0 ? getWidth() : 300;
        double h = getHeight() > 0 ? getHeight() : 300;
        double radius = Math.min(w, h) * 0.45;
        double cx = w / 2.0, cy = h / 2.0;

    //Circle Face
        Circle circle = new Circle(cx, cy, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
    //Labels
        Text t12 = new Text(cx - 6, cy - radius + 18, "12");
        Text t3 = new Text(cx + radius - 18, cy + 6, "3");
        Text t6 = new Text(cx - 6, cy + radius - 6, "6");
        Text t9 = new Text(cx - radius + 6, cy, "9");
        Font markFont = Font.font(14);
        t12.setFont(markFont);
        t3.setFont(markFont);
        t6.setFont(markFont);
        t9.setFont(markFont);

        getChildren().addAll(circle, t12, t3, t6, t9);

    //Angles
        double secondAngle = second * 6;
        double minuteAngle = (minute + second / 60.0) * 6;
        double hourAngle = (hour % 12 + minute / 60.0) * 30;

    //Hand lengths
        double lenSecond = radius * 0.75;
        double lenMinute = radius * 0.65;
        double lenHour = radius * 0.5;

    //Draw hands Conditionally
        if (isHourHandVisible()) {
            Line hHand = new Line(cx, cy, cx + lenHour * Math.sin(hourAngle), cy - lenHour * Math.cos(hourAngle));
            hHand.setStrokeWidth(4);
            getChildren().add(hHand);
        }
        if (isMinuteHandVisible()) {
            Line mHand = new Line(cx, cy, cx + lenMinute * Math.sin(minuteAngle), cy - lenMinute * Math.cos(minuteAngle));
            mHand.setStrokeWidth(3);
            getChildren().add(mHand);
        }
        if (isSecondHandVisible()) {
            Line sHand = new Line(cx, cy, cx + lenSecond * Math.sin(secondAngle), cy - lenSecond * Math.cos(secondAngle));
            sHand.setStrokeWidth(1.5);
            sHand.setStroke(Color.RED);
            getChildren().add(sHand);
        }
    }
}
