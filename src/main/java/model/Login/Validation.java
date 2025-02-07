package model.Login;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.Strings;

public class Validation {


    public static String validation(TextField txtUser, PasswordField txtPass, TextField txtCaptcha,
                                    String answer) {
        if (txtUser.getText().isEmpty()) return Strings.USER_REQUIRED.getText();
        if (txtPass.getText().isEmpty()) return Strings.PASSWORD_REQUIRED.getText();
        if (txtCaptcha.getText().isEmpty()) return Strings.CAPTCHA_EMPTY.getText();
        if (!answer.equals(txtCaptcha.getText())) return Strings.CAPTCHA_ERROR.getText();
        return null; // Everything is fine
    }
}