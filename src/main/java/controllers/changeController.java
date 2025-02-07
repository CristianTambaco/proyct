package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import themes.ThemeManager;
import utils.Colors;

import java.util.List;
import java.util.Map;

public class changeController {

    private final ThemeManager themeManager = new ThemeManager();


    /**
     * ANCHOR PANE
     */
    @FXML
    private AnchorPane main;


    /**
     * SVG PATHS
     */
    @FXML
    private SVGPath svgLock;

    @FXML
    private SVGPath svgNewPass;

    @FXML
    private SVGPath svgPassCheck;


    /**
     * LABELS
     */
    @FXML
    private Label lblInfo;

    @FXML
    private Label lblLock;


    /**
     * METHOD CHANGE THEME
     */
    @FXML
    void changeTheme() {
        boolean light = themeManager.toggleTheme(main, 100);

        // Colores según el tema
        Color svgColor = light ? Colors.BLACK.getColor() : Colors.WHITE.getColor();
        Color infoColor = light ? Colors.RED_LIGHT.getColor() : Colors.RED_DARK.getColor();
        Map<Label, Color> labelColorMap = getLabelColorMap(light, svgColor, infoColor);

        labelColorMap.forEach(Label :: setTextFill);
    }

    private Map<Label, Color> getLabelColorMap(boolean light, Color svgColor, Color infoColor) {
        Color textColor = light ? Colors.BLACK.getColor() : Colors.WHITE.getColor();

        // Actualizar colores de los SVG
        List<SVGPath> svgElements = List.of(svgLock, svgNewPass, svgPassCheck);
        svgElements.forEach(svg -> svg.setFill(svgColor));

        // Actualizar colores de las etiquetas
        return Map.of(
                lblLock, textColor,
                lblInfo, infoColor
        );
    }

    @FXML
    void changePassword() {

    }

}