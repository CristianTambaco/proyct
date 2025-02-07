package themes;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import utils.Paths;

public class ThemeManager {

    private boolean light = true;

    public boolean toggleTheme(AnchorPane root, int duration) {
        light = !light;
        transition(root, light ? Paths.LIGHT_THEME.getPath() : Paths.DARK_THEME.getPath(), duration);
        return light;
    }

    private void transition (AnchorPane root, String newTheme, int duration) {

        // Transición de desvanecimiento
        FadeTransition fadeOut = new FadeTransition(Duration.millis(duration), root);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(_ -> {
            // Cambiar tema cuando la opacidad es 0
            root.getStylesheets().clear();
            root.getStylesheets().add(newTheme);

            // Transición para volver a mostrar
            FadeTransition fadeIn = new FadeTransition(Duration.millis(duration), root);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        fadeOut.play();
    }
}