package sample;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    boolean flag = false;
    @FXML
    TextField tf;
    @FXML
    ChoiceBox ChoiseSloj;
    @FXML
    Slider slider;
    @FXML
    Button btn;
    @FXML
    Text Podskazka;
    @FXML
    Text Pass;
    String Password;

    public void GoGeneration() {
        Password = "";
        Pass.setText("");
        Password = new GenPass(Integer.valueOf(String.valueOf(ChoiseSloj.getValue())), Integer.valueOf(tf.getText())).Pass();
    if (Password.length() < 61) Pass.setText(Password);
        else Pass.setText(Password.substring(0, 51) + "\n" + Password.substring(51));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Password), null);
    }
    public void ChangeLength() {
        flag = true;
    }

    public void unbind() {
        tf.textProperty().unbind();
        tf.selectAll();
    }
    public void bind() {
        tf.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChoiseSloj.getItems().setAll(1, 2, 3, 4, 5);
        ChoiseSloj.setValue(4);
        Platform.runLater(() -> btn.requestFocus());
        tf.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (flag) {
                flag = false;
                if (!oldValue.equals(newValue)) {
                    tf.setText(newValue.replaceAll("[^0-9]", ""));
                    if (tf.getText().length() > 2) if (Integer.valueOf(tf.getText()) > 100) tf.setText(oldValue);
                    if (tf.getText().isEmpty() || Integer.valueOf(tf.getText()) < 5) {
                        slider.setValue(5);
                        btn.setDisable(true);
                    }
                    else {
                        btn.setDisable(false);
                        slider.setValue(Integer.valueOf(tf.getText()));
                    }
                }
            }
        });
        ChoiseSloj.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (Integer.valueOf(String.valueOf(newValue))) {
                case 1:
                    Podskazka.setText("*Только цифры.");
                    break;
                case 2:
                    Podskazka.setText("*Английские буквы.");
                    break;
                case 3:
                    Podskazka.setText("*Английские буквы и цифры.");
                    break;
                case 4:
                    Podskazka.setText("*Английские буквы разных регистров и цифры.");
                    break;
                case 5:
                    Podskazka.setText("*Англ. и Рус. буквы разных регистров и цифры.");
                    break;
            }
        });
    }
}
