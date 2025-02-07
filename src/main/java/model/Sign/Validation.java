package model.Sign;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utils.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final byte LIMIT = 5;

    public static String validation(TextField txtEmail, TextField txtUser, TextField txtPass,
                                    TextField txtConfirm, TextField txtAnswer, ComboBox<String> boxQuestion) {

        String validationMessage = validateEmail(txtEmail);
        if (validationMessage != null) return validationMessage;


        if (txtUser.getText().isEmpty()) return Strings.USER_REQUIRED.getText();
        if (txtPass.getText().isEmpty()) return Strings.PASSWORD_REQUIRED.getText();
        if (txtPass.getText().length() <= LIMIT) return Strings.PASSWORD_LENGTH.getText();
        if (!txtConfirm.getText().equals(txtPass.getText())) return Strings.PASSWORD_MISMATCH.getText();
        if (txtAnswer.getText().isEmpty()) return Strings.ANSWER_REQUIRED.getText();
        if (boxQuestion.getValue() == null) return Strings.QUESTION_PROMPT.getText();

        return null;
    }

    private static String validateEmail(TextField txtEmail) {
        String email = txtEmail.getText();
        if (email.isEmpty()) return Strings.EMAIL_REQUIRED.getText();
        if (!emailSyntax(email))  return Strings.EMAIL_SYNTAX.getText();
        return null;
    }

    private static boolean emailSyntax(String email) {
        // Expresión regular ajustada para permitir más caracteres y TLD más largos
        String regex = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";

        // Crear un patrón con la expresión regular
        Pattern pattern = Pattern.compile(regex);

        // Validar el correo electrónico
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static String validateUser(TextField txtUser) {
        return "";
    }
}