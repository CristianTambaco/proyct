package themes.Main;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class FadeMain {

    public static void out(AnchorPane main, EventHandler<ActionEvent> onFinished) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), main);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(onFinished); // Agregar callback
        fadeOut.play();
    }

    public static void in(AnchorPane main) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), main);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}