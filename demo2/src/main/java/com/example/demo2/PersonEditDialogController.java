package com.example.demo2;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.demo2.Person;
//import ch.makery.address.util.DateUtil;

public class PersonEditDialogController {
    @FXML
    private TextField NameField;
    @FXML
    private TextField RankField;
    @FXML
    private TextField DegreeField;
    @FXML
    private TextField postField;
    @FXML
    private TextField lessonField;
    @FXML
    private TextField lesson_typeField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        NameField.setText(person.getName());
        RankField.setText(person.getRank());
        DegreeField.setText(person.getDegree());
        postField.setText(person.getPost());
        lessonField.setText(person.getlesson());
        lesson_typeField.setText(person.getlesson_type());

    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(NameField.getText());
            person.setRank(RankField.getText());
            person.setDegree(DegreeField.getText());
            person.setPost(postField.getText());
            person.setlesson(lessonField.getText());
            person.setlesson_type(lesson_typeField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (RankField.getText() == null || RankField.getText().length() == 0) {
            errorMessage += "No valid rank!\n";
        }
        if (DegreeField.getText() == null || DegreeField.getText().length() == 0) {
            errorMessage += "No valid degree!\n";
        }

        if (postField.getText() == null || postField.getText().length() == 0) {
            errorMessage += "No valid post!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(postField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (lessonField.getText() == null || lessonField.getText().length() == 0) {
            errorMessage += "No valid lesson!\n";
        }
        if (lesson_typeField.getText() == null || lesson_typeField.getText().length() == 0) {
            errorMessage += "No valid lesson!\n";
        }
/**
        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }
*/
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
