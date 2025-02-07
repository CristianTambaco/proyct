package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import model.Captcha.Captcha;
import model.Captcha.CaptchaValidation;
import model.Loaders.LinkLoader;
import model.Sign.SecurityQuestion;
import themes.Fade;
import themes.ThemeManager;
import utils.Colors;
import utils.Paths;
import utils.Strings;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class questionController {

    private static final Logger logger = Logger.getLogger(questionController.class.getName());
    private final CaptchaValidation captchaValidation = new CaptchaValidation();
    private final SecurityQuestion securityQuestion = new SecurityQuestion();
    private final ThemeManager themeManager = new ThemeManager();
    Captcha captcha = captchaValidation.getRandomCaptcha();

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
    private SVGPath svgUser;

    @FXML
    private SVGPath svgAnswer;

    /**
     * TEXT FIELDS
     */
    @FXML
    private TextField question;

    @FXML
    private TextField txtAnswer;

    @FXML
    private TextField txtCaptcha;

    @FXML
    private TextField txtUser;


    /**
     * LABELS
     */
    @FXML
    private Label lblLock;

    @FXML
    private Label lblInfo;

    @FXML
    private Label lblForget;


    /**
     * COMBO BOX FIELD
     */
    @FXML
    private ComboBox <String> boxQuestion;


    /**
     * IMAGE FIELD
     */
    @FXML
    private ImageView imgCaptcha;


    @FXML
    void changeChange() {

    }

    @FXML
    void changeSign() {
        try {
            // Cargar el archivo signView.fxml
            var signView = LinkLoader.getResource(Paths.SIGN_VIEW.getPath());
            AnchorPane signPane = FXMLLoader.load(signView);

            // Reemplazar el contenido de 'main' con la nueva vista
            Fade.out(main);
            main.getChildren().clear();
            main.getChildren().setAll(signPane);
            Fade.in(main);

        } catch (IOException e) {
            logger.log(Level.SEVERE, Strings.E_LOGGER.getText(), e);
        }
    }

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
        List<SVGPath> svgElements = List.of(svgLock, svgUser, svgAnswer);
        svgElements.forEach(svg -> svg.setFill(svgColor));

        // Actualizar colores de las etiquetas
        return Map.of(
                lblLock, textColor,
                lblInfo, infoColor,
                lblForget, textColor
        );
    }


    @FXML
    void initialize() {
        imgCaptcha.setImage(captcha.image());
        String answer = captcha.answer();

        securityQuestion.securityQuestion(boxQuestion);
        boxQuestion.valueProperty().addListener((_, _, newValue) -> {
            if (newValue != null) question.setText(newValue);
        });
    }
}