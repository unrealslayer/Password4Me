//: GetPassword/Controller.java

package GetPassword;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
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
import java.util.ResourceBundle;
    /** Processes events scene
     * @author deadboy
     * @author leo13pard@ya.ru
     * @version 1.0
     */
public class Controller implements Initializable{
    /** If you press in the input field password length then "flag = true",
     * and the listener listens to the input field length of the last change
     * and the "flag = false" until you press in the input field of the password length .
     */
    boolean flag = false;
    /** The "password" that is displayed in the output password.
     */
    String Password;

    /** The "text-field" that contains the length of the password.*/
    @FXML
    TextField tf;
    /** The "choice-box" that contains the kind of the password.*/
    @FXML
    ChoiceBox ChoiseSloj;
    /** The "slider" allows "touch" to choose the password length.*/
    @FXML
    Slider slider;
    /** The "button" starts the generation of a password.*/
    @FXML
    Button btn;
    /** The "text with hint" showing what type of password you selected.*/
    @FXML
    Text Podskazka;
    /** The "text with result" displaying the generated password.*/
    @FXML
    Text Pass;
    /** The method "GoGeneration()" starts when you press the
     * button "Generate". It generates password, displays it
     * in the "text with result" and copy to the clipboard.
     */
    public void GoGeneration() {
        Password = "";
        Pass.setText("");
        GenPass gp = new GenPass(Integer.valueOf(String.valueOf(ChoiseSloj.getValue())), Integer.valueOf(tf.getText()));
        Password = gp.GetPassword();
        if (Password.length() < 61) Pass.setText(Password);
        else Pass.setText(Password.substring(0, 51) + "\n" + Password.substring(51));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Password), null);
    }
    /** The method "ChangeLength()" called when the button is
     * pressed in the input field of the password length.
     */
    public void ChangeLength() {
        flag = true;
    }
    /** The method "unbind()" called when in the input field of the
     * password length intercepts <i>DragDetected | MouseClicked | TouchPressed</i>.
     * It unbind "text field" and "slider", and select all text in "text field".
     */
    public void unbind() {
        tf.textProperty().unbind();
        tf.selectAll();
    }
    /** The method "bind()" called when slider intercepts <i>DragDetected | MouseClicked</i>.
     * It bind  "text field" and "slider".
     */
    public void bind() {
        tf.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
    }
    /** The method of initializing a set of objects in ChoiceBox and
     * sets the default value, moves the focus to the password generation button, bind
     * like a method "bind", set listener on "text-field" which allows to enter
     * the "number" of not more than 100 and not less than 5, and set listener on ChoiceBox which
     * show hint for kind of the password.
     */
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
