package themes;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Fade {

    public static void out(AnchorPane main) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), main);
        fadeTransition.setFromValue(1.0); // Comienza totalmente visible
        fadeTransition.setToValue(0.0);   // Se desvanece completamente
        fadeTransition.play();
    }

    public static void in(AnchorPane main) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), main);
        fadeTransition.setFromValue(0.0); // Comienza invisible
        fadeTransition.setToValue(1.0);   // Se vuelve completamente visible
        fadeTransition.play();
    }
}