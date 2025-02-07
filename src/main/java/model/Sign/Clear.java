package model.Sign;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utils.Strings;

public class Clear {

    public static void clearField(TextField txtEmail, TextField txtUser, TextField txtPass, TextField txtConfirm,
                                  ComboBox <String> questionBox, TextField answer) {
        txtEmail.setText(Strings.EMPTY.getText());
        txtUser.setText(Strings.EMPTY.getText());
        txtPass.setText(Strings.EMPTY.getText());
        txtConfirm.setText(Strings.EMPTY.getText());
        questionBox.getSelectionModel().clearSelection();
        questionBox.setPromptText(Strings.QUESTION_PROMPT.getText());
        answer.setText(Strings.EMPTY.getText());
    }
}