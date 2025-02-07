package controllers;

import exceptions.FirebaseExceptions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import model.Database.Sign;
import model.Loaders.LinkLoader;
import model.Sign.Clear;
import model.Sign.SecurityQuestion;
import model.Sign.Validation;
import themes.Fade;
import themes.Sleep;
import themes.ThemeManager;
import utils.Colors;
import utils.Paths;
import utils.Strings;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class signController {

    private static final Logger logger = Logger.getLogger(signController.class.getName());
    private final SecurityQuestion securityQuestion = new SecurityQuestion();
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
    private SVGPath svgSign;

    @FXML
    private SVGPath svgEmail;

    @FXML
    private SVGPath svgUser;

    @FXML
    private SVGPath svgLock;

    @FXML
    private SVGPath svgCheck;

    @FXML
    private SVGPath svgAnswer;


    /**
    * TEXT FIELDS
    */
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtAnswer;

    @FXML
    private TextField question;


    /**
    * LABELS
    */
    @FXML
    private Label lblInfo;

    @FXML
    private Label lblAlready;

    @FXML
    private Label lblRegister;


    /**
     * PASSWORD FIELDS
    */
    @FXML
    private PasswordField txtPass;

    @FXML
    private PasswordField txtConfirm;


    /**
     * COMBO BOX FIELD
    */
    @FXML
    private ComboBox<String> boxQuestion;


    /**
     * METHOD INITIALIZATION
    */
    @FXML
    void initialize() {
        securityQuestion.securityQuestion(boxQuestion);
        boxQuestion.valueProperty().addListener((_, _, newValue) -> {
            if (newValue != null) question.setText(newValue);
        });
    }


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
        List<SVGPath> svgElements = List.of(svgSign, svgAnswer, svgUser, svgLock, svgCheck, svgEmail);
        svgElements.forEach(svg -> svg.setFill(svgColor));

        // Actualizar colores de las etiquetas
        return Map.of(
                lblAlready, textColor,
                lblInfo, infoColor,
                lblRegister, textColor
        );
    }


    /**
     * METHOD SIGN
    */
    @FXML
    void sign() throws FirebaseExceptions {
        lblInfo.setText(Strings.EMPTY.getText());

        // Validar los campos y obtener el mensaje de error (si hay uno)
        String errorMessage = Validation.validation(txtEmail, txtUser, txtPass, txtConfirm, txtAnswer, boxQuestion);
        if (errorMessage != null) {
            lblInfo.setText(errorMessage);
            return;
        }

        // Llamar al method de registro si no hay errores
        String message = Sign.signUser(txtUser, txtEmail, txtPass, txtAnswer, question);
        lblInfo.setText(message);
        Clear.clearField(txtEmail, txtUser, txtPass, txtConfirm, boxQuestion, txtAnswer);
        Sleep.pause(this::changeLogin);
    }


    /**
     * CHANGE VIEW
    */
    @FXML
    private void changeLogin() {
        try {
            // Cargar el archivo loginView.fxml
            var loginView = LinkLoader.getResource(Paths.LOGIN_VIEW.getPath());
            AnchorPane loginPane = FXMLLoader.load(loginView);

            // Reemplazar el contenido de 'main' con la nueva vista
            Fade.out(main);
            main.getChildren().clear();
            main.getChildren().setAll(loginPane);
            Fade.in(main);

        } catch (IOException e) { logger.log(Level.SEVERE, Strings.E_LOGGER.getText(), e); }
    }
}