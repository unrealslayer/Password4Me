package GetPassword.Settings_package;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by deadboy on 10.11.15.
 */
public class SettingsController implements Initializable{
    @FXML
    AnchorPane AnchorPane;
    @FXML
    Button btnOK;
    @FXML
    Button btnCancel;
    @FXML
    ToggleButton pos_1_1;
    @FXML
    ToggleButton pos_1_2;
    @FXML
    ToggleButton pos_1_3;
    @FXML
    ToggleButton pos_1_4;
    @FXML
    ToggleButton pos_1_5;
    @FXML
    ToggleButton pos_1_6;
    @FXML
    ToggleButton pos_1_7;
    @FXML
    ToggleButton pos_1_8;
    @FXML
    ToggleButton pos_1_9;
    @FXML
    ToggleButton pos_1_10;
    @FXML
    ToggleButton pos_1_11;
    @FXML
    ToggleButton pos_1_12;
    @FXML
    ToggleButton pos_2_1;
    @FXML
    ToggleButton pos_2_2;
    @FXML
    ToggleButton pos_2_3;
    @FXML
    ToggleButton pos_2_4;
    @FXML
    ToggleButton pos_2_5;
    @FXML
    ToggleButton pos_2_6;
    @FXML
    ToggleButton pos_2_7;
    @FXML
    ToggleButton pos_2_8;
    @FXML
    ToggleButton pos_2_9;
    @FXML
    ToggleButton pos_2_10;
    @FXML
    ToggleButton pos_2_11;
    @FXML
    ToggleButton pos_3_1;
    @FXML
    ToggleButton pos_3_2;
    @FXML
    ToggleButton pos_3_3;
    @FXML
    ToggleButton pos_3_4;
    @FXML
    ToggleButton pos_3_5;
    @FXML
    ToggleButton pos_3_6;
    @FXML
    ToggleButton pos_3_7;
    @FXML
    ToggleButton pos_3_8;
    @FXML
    ToggleButton pos_3_9;
    @FXML
    ToggleButton btn_up;
    @FXML
    ToggleButton btn_low;
    @FXML
    ToggleButton btn_enRU;
    @FXML
    Text ru_en_text;

    private ToggleButton[] tBtns_en_ru = new ToggleButton[26];
    private ToggleButton[] tBtns_ru = new ToggleButton[6];
    private final String[] ENG_ALPHABET = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D",
                                           "F","G","H","J","K","L","Z","X","C","V","B","N","M"};
    private final String[] RU_ALPHABET = {"Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Х","Ъ","Ф","Ы","В","А",
                                          "П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю"};
    private boolean btnsState_en_ru[][][] = new boolean[26][2][2];  //en-ru=1-0, BIG-small=1-0, pressed-not=1-0
    private boolean btnState_ru[][] = new boolean[6][2];                 //BIG-small=1-0, pressed-not=1-0

    void InitArrays() {
        tBtns_en_ru[0] = pos_1_1;
        tBtns_en_ru[1] = pos_1_2;
        tBtns_en_ru[2] = pos_1_3;
        tBtns_en_ru[3] = pos_1_4;
        tBtns_en_ru[4] = pos_1_5;
        tBtns_en_ru[5] = pos_1_6;
        tBtns_en_ru[6] = pos_1_7;
        tBtns_en_ru[7] = pos_1_8;
        tBtns_en_ru[8] = pos_1_9;
        tBtns_en_ru[9] = pos_1_10;
        tBtns_en_ru[10] = pos_2_1;
        tBtns_en_ru[11] = pos_2_2;
        tBtns_en_ru[12] = pos_2_3;
        tBtns_en_ru[13] = pos_2_4;
        tBtns_en_ru[14] = pos_2_5;
        tBtns_en_ru[15] = pos_2_6;
        tBtns_en_ru[16] = pos_2_7;
        tBtns_en_ru[17] = pos_2_8;
        tBtns_en_ru[18] = pos_2_9;
        tBtns_en_ru[19] = pos_3_1;
        tBtns_en_ru[20] = pos_3_2;
        tBtns_en_ru[21] = pos_3_3;
        tBtns_en_ru[22] = pos_3_4;
        tBtns_en_ru[23] = pos_3_5;
        tBtns_en_ru[24] = pos_3_6;
        tBtns_en_ru[25] = pos_3_7;

        tBtns_ru[0] = pos_1_11;
        tBtns_ru[1] = pos_1_12;
        tBtns_ru[2] = pos_2_10;
        tBtns_ru[3] = pos_2_11;
        tBtns_ru[4] = pos_3_8;
        tBtns_ru[5] = pos_3_9;

        boolean a = true;
        for (int k = 1; k > 0; k--) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 26; i++) btnsState_en_ru[i][k][j] = a;   //en-(BIG-small) Pressed
            }                                                                //ru-(BIG-SMALL) Unpressed
            a = false;
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 6; i++) btnState_ru[i][j] = false;  //BIG-small Unpressed
        }
    }

    public void change_enRU() {
        if (btn_enRU.selectedProperty().getValue()) {
            //Pressed
            for (int i = 0; i < 26; i++) {
                if (btn_up.selectedProperty().getValue()) {
                    tBtns_en_ru[i].selectedProperty().getValue()

                } else {

                }
            }
            ru_en_text.setText("Кириллица");
            btn_enRU.setText("Ru");

        } else {
            //Unpressed

        }
    }

    public void change_UP() {
        //change sessions like a change_enRU
    }

    public void change_LOW() {

    }

    public void OKevent() {
        SettingsWindow sw = new SettingsWindow();
        sw.GetPane().setDisable(false);
        sw.GetStage().close();
    }

    public void CANCELevent() {
        SettingsWindow sw = new SettingsWindow();
        sw.GetPane().setDisable(false);
        sw.GetStage().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> btnOK.requestFocus());
        InitArrays();
        for (ToggleButton tb : tBtns_en_ru) tb.fire();
    }
}
