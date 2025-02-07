package model.Sign;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import utils.Strings;

public class SecurityQuestion {

    public void securityQuestion(ComboBox<String> boxQuestion) {

        boxQuestion.setItems(FXCollections.observableArrayList(
                Strings.FIRST_TEACHER.getText(),
                Strings.FIRST_PET.getText(),
                Strings.BIRTH_CITY.getText(),
                Strings.BIRTH_MONTH.getText(),
                Strings.FAVORITE_BOOK.getText()
        )); boxQuestion.setPromptText(Strings.QUESTION_PROMPT.getText());
    }
}