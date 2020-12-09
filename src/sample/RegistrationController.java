package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private ScrollPane phonesScrollPane;

    private List<TextField> phoneNumbersTextFields = new ArrayList<>();

    public void initialize() {
        VBox phonesVBox = new VBox();
        phonesVBox.setSpacing(6);
        phonesVBox.setPadding(new Insets(8, 8, 8, 8));

        HBox initialHBox = new HBox();
        initialHBox.setSpacing(12);
        TextField initialTextField = getPhoneTextField();
        Button addButton = new Button("+");
        addButton.setStyle("-fx-font-size: 15px; -fx-cursor: hand;");
        initialHBox.getChildren().addAll(initialTextField, addButton);
        phoneNumbersTextFields.add(initialTextField);

        addButton.setOnAction(actionEvent -> {
            TextField textField = getPhoneTextField();
            phonesVBox.getChildren().add(textField);
            phoneNumbersTextFields.add(textField);
        });

        phonesVBox.getChildren().add(initialHBox);

        phonesScrollPane.setContent(phonesVBox);
    }

    public void onRegister() {
        String username = usernameTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();

        System.out.println(username + " " + password1 + " " + password2);

        for (TextField textField : phoneNumbersTextFields) {
            System.out.println(textField.getText());
        }
    }

    private TextField getPhoneTextField() {
        TextField textField = new TextField();
        textField.setStyle("-fx-font-size: 15px;");
        textField.setPrefWidth(295);
        textField.setMaxWidth(295);
        return textField;
    }
}
