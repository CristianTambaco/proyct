package model.Loaders;

import javafx.scene.image.Image;
import utils.Strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageLoader {

    // Crear un logger para la clase
    private static final Logger logger = Logger.getLogger(ImageLoader.class.getName());

    public static Image loadImage(String path) {
        try {
            // Usar el class loader para obtener el recurso
            var resource = ImageLoader.class.getResourceAsStream(path);

            // Verificar si el recurso es nulo
            if (resource == null) {
                logger.severe(Strings.IMAGE_404.getText() + path);
                return null; // Retornar nulo si no se encuentra
            }

            // Crear y retornar la imagen
            return new Image(resource);

        } catch (Exception e) {
            logger.log(Level.SEVERE, Strings.IMAGE_LOAD.getText() + path, e);
            return null;
        }
    }
}