package model.Loaders;
import utils.Strings;
import java.net.URL;

public class LinkLoader {

    public static URL getResource(String path) {
        // Obtener el recurso
        URL resource = LinkLoader.class.getResource(path);

        // Verificar si el recurso es nulo
        if (resource == null) { System.err.println(Strings.FXML_404.getText() + path); }

        // Asegurarse de que el recurso no es nulo (con assert)
        assert resource != null : Strings.RESOURCE_404.getText() + path;
        return resource;
    }
}