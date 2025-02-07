package model.Database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Firebase.Connection;
import utils.Strings;

public class Login {

    private static final FirebaseAuth auth = Connection.getAuthInstance();

    public static String login(TextField txtUser, PasswordField txtPassword) {
        String user = txtUser.getText();
        String password = txtPassword.getText();

        

        return Strings.LOGIN_SUCCESSFULLY.getText();
    }
}