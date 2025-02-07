package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.SVGPath;
import model.Captcha.Captcha;
import model.Captcha.CaptchaValidation;
import model.Database.Login;
import model.Loaders.LinkLoader;
import model.Login.Clear;
import model.Login.Validation;
import themes.Fade;
import themes.Sleep;
import themes.ThemeManager;
import javafx.scene.paint.Color;
import utils.Colors;
import utils.Paths;
import utils.Strings;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loginController {

    private static final Logger logger = Logger.getLogger(loginController.class.getName());
    private final CaptchaValidation captchaValidation = new CaptchaValidation();
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
    private SVGPath svgLogin;

    @FXML
    private SVGPath svgUser;

    @FXML
    private SVGPath svgPass;


    /**
     * TEXT FIELDS
     */
    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField tfCaptcha;


    /**
     * LABELS
     */
    @FXML
    private Label lblLogin;

    @FXML
    private Label lblInfo;

    @FXML
    private Label lblAccount;


    /**
     * CHECK BOX
     */
    @FXML
    private CheckBox boxShow;


    /**
     * IMAGE - CAPTCHA
     */
    @FXML
    private ImageView imgCaptcha;


    /**
     * METHOD INITIALIZATION
     */
    @FXML
    String initialize() {
        imgCaptcha.setImage(captcha.image());
        return captcha.answer();
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
        List<SVGPath> svgElements = List.of(svgLogin, svgUser, svgPass);
        svgElements.forEach(svg -> svg.setFill(svgColor));

        // Actualizar colores de las etiquetas
        return Map.of(
                lblLogin, textColor,
                lblInfo, infoColor,
                lblAccount, textColor
        );
    }


    /**
     * CHANGE VIEW
     */
    @FXML
    private void changeSign() {
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

    
    /**
     * METHOD LOGIN
     */
    @FXML
    void login() {
        lblInfo.setText(Strings.EMPTY.getText());

        // Validar los campos y obtener el mensaje de error (si hay uno)
        String answerC = initialize();
        String errorMessage = Validation.validation(tfUsername, tfPassword, tfCaptcha, answerC);
        if (errorMessage != null) {
            lblInfo.setText(errorMessage);
            return;
        }

        // Llamar al method de registro si no hay errores
        String message = Login.login(tfUsername, tfPassword);
        lblInfo.setText(message);
        Clear.clearField(tfUsername, tfPassword, tfCaptcha);
        Sleep.pause(this::changeMain);
    }


    @FXML
    void changeQuestion() {
        try {
            // Cargar el archivo signView.fxml
            var questionView = LinkLoader.getResource(Paths.QUESTION_VIEW.getPath());
            AnchorPane questionPane = FXMLLoader.load(questionView);

            // Reemplazar el contenido de 'main' con la nueva vista
            Fade.out(main);
            main.getChildren().clear();
            main.getChildren().setAll(questionPane);
            Fade.in(main);

        } catch (IOException e) {
            logger.log(Level.SEVERE, Strings.E_LOGGER.getText(), e);
        }
    }


    @FXML
    private void showPassword() {
        String passwordTF = tfPassword.getText();
        String passwordTX = txtPassword.getText();
        // Usamos el estado del checkbox para determinar qué mostrar
        boolean isSelected = boxShow.isSelected();

        txtPassword.setText(passwordTF);         // Colocar el texto en txtPassword (si es visible o no)
        tfPassword.setText(passwordTX);          // Colocar el texto en tfPassword (si es visible o no)
        txtPassword.setVisible(isSelected);       // Mostrar u ocultar txtPassword según el estado del checkbox
        tfPassword.setVisible(!isSelected);       // Si el checkbox está seleccionado, ocultar tfPassword
    }


    private void changeMain() {

    }
}