package model.Database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.scene.control.TextField;
import model.Firebase.Connection;
import model.Firebase.Provider;
import utils.Strings;

import java.util.HashMap;
import java.util.Map;

public class Sign {

    private static final FirebaseAuth auth = Connection.getAuthInstance();

    public static String signUser(TextField user, TextField email, TextField password, TextField answer,
                                  TextField selectedQuestion) {

        int ID = (int) (Math.random() * 10000);

        try {
            Map <String, Object> data = new HashMap<>();
            data.put(Strings.USER.getText(), user.getText());
            data.put(Strings.EMAIL.getText(), email.getText());
            data.put(Strings.PASSWORD.getText(), password.getText());
            data.put(Strings.SECURITY_QUESTION.getText(), selectedQuestion.getText());
            data.put(Strings.SECURITY_ANSWER.getText(), answer.getText());
            Provider.save(Strings.USER.getText(), String.valueOf(ID), data);
            createUser(email.getText(), password.getText());
            return Strings.ACCOUNT_CREATED.getText();

        } catch (Exception e) {
            System.err.println(Strings.ERROR.getText() + e.getMessage());
            return Strings.ERROR.getText() + e.getMessage();
        }
    }


    private static void createUser(String email, String password) {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);

            UserRecord userRecord = auth.createUser(request);
            System.out.println("Usuario creado con UID: " + userRecord.getUid());

        } catch (FirebaseAuthException e) {
            System.err.println("Error creando el usuario: " + e.getMessage());
        }
    }
}