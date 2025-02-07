package model.Login;

import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.Strings;

public class Clear {

    public static void clearField(TextField txtUser, PasswordField txtPass, TextField txtCaptcha) {
        txtUser.setText(Strings.EMPTY.getText());
        txtPass.setText(Strings.EMPTY.getText());
        txtCaptcha.setText(Strings.EMPTY.getText());
    }
}