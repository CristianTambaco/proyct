package themes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Sleep {

    public static void pause(Runnable action) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), _ -> action.run())
                // Ejecutar acción después de la pausa
        );
        timeline.setCycleCount(1); // Ejecutar solo una vez
        timeline.play();
    }
}