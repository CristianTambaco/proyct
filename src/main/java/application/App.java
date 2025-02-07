package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Firebase.Connection;
import model.Loaders.ImageLoader;
import model.Loaders.LinkLoader;
import utils.Paths;
import utils.Strings;
import java.util.logging.Level;
import java.util.logging.Logger; 


public class App extends Application { 

    // Crear un logger para la clase
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {

        try {
            // 🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸
            // Connection to Firebase
            Connection.connect();

            // Cargar la imagen de la ventana
            Image windowImage = ImageLoader.loadImage(Paths.WINDOW_ICON.getPath());

            // Cargar el recurso FXML
            var resource = LinkLoader.getResource(Paths.LAUNCHER.getPath());
            AnchorPane root = FXMLLoader.load(resource);

            // Configurar el ícono de la ventana
            if (windowImage != null) { stage.getIcons().add(windowImage); }

            // Configurar el título de la ventana
            stage.setTitle(Strings.WINDOW_TITLE.getText());

            // Crear la escena
            Scene scene = new Scene(root);

            // Establecer la escena en el escenario
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) { logger.log(Level.SEVERE, Strings.E_LOGGER.getText(), e); }
    }
}