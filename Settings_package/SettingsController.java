package GetPassword.Settings_package;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    ToggleButton tab1_1_1;
    @FXML
    ToggleButton tab1_1_2;
    @FXML
    ToggleButton tab1_1_3;
    @FXML
    ToggleButton tab1_2_1;
    @FXML
    ToggleButton tab1_2_2;
    @FXML
    ToggleButton tab1_2_3;
    @FXML
    ToggleButton tab1_3_1;
    @FXML
    ToggleButton tab1_3_2;
    @FXML
    ToggleButton tab1_3_3;
    @FXML
    ToggleButton tab1_4_1;
    @FXML
    ToggleButton tab1_4_2;
    @FXML
    ToggleButton tab1_4_3;
    @FXML
    ToggleButton tab2_1_1;
    @FXML
    ToggleButton tab2_1_2;
    @FXML
    ToggleButton tab2_1_3;
    @FXML
    ToggleButton tab2_2_1;
    @FXML
    ToggleButton tab2_2_2;
    @FXML
    ToggleButton tab2_2_3;
    @FXML
    ToggleButton tab2_3_1;
    @FXML
    ToggleButton tab2_3_2;
    @FXML
    ToggleButton tab2_3_3;
    @FXML
    ToggleButton tab2_4_1;
    @FXML
    ToggleButton tab2_4_2;
    @FXML
    ToggleButton tab2_4_3;
    @FXML
    ToggleButton btn_up;
    @FXML
    ToggleButton btn_low;
    @FXML
    ToggleButton btn_enRU;
    @FXML
    Text ru_en_text;
    @FXML
    RadioButton mySym_T_F;
    @FXML
    Label addUSym;
    @FXML
    TextField setUSym;
    @FXML
    RadioButton setOnlyMySym;
    @FXML
    ToggleButton btn_UpCase;
    @FXML
    ToggleButton btn_LowCase;
    @FXML
    ToggleButton btn_OnlyMyCase;
    @FXML
    Text exa_password;



    private ToggleButton[] tBtns_en_ru = new ToggleButton[26];
    private ToggleButton[] tBtns_ru = new ToggleButton[6];

    private final String[] ENG_ALPHABET = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D",
                                           "F","G","H","J","K","L","Z","X","C","V","B","N","M"};
    private final String[] RU_ALPHABET = {"Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Ф","Ы","В","А",
                                          "П","Р","О","Л","Д","Я","Ч","С","М","И","Т","Ь"};

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
        for (int k = 1; k > 0; k--) {       //en->ru
            for (int j = 0; j < 2; j++) {   //Big->small
                for (int i = 0; i < 26; i++) btnsState_en_ru[i][k][j] = a;   //en-(BIG-small) Pressed
            }                                                                //ru-(BIG-SMALL) Unpressed
            a = false;                                                       //k=1->en | j=0->BIG
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 6; i++) btnState_ru[i][j] = false;  //BIG-small Unpressed
        }
    }

    private void change_save(int en_ru, int big_small) {
        for (int i = 0; i < 26; i++) {
            btnsState_en_ru[i][en_ru][big_small] = tBtns_en_ru[i].isSelected();
        }
        if (en_ru==0) {
            for (int i =0; i < 6; i++) {
                btnState_ru[i][big_small] = tBtns_ru[i].isSelected();
            }
        }
    }

    private void load_alph(boolean en_ru) { //false=en
        for (int i = 0; i < 26; i++) {
            tBtns_en_ru[i].setText((!en_ru) ? ENG_ALPHABET[i] : RU_ALPHABET[i]);
            if (btnsState_en_ru[i][!en_ru?1:0][btn_up.isSelected()?1:0]) tBtns_en_ru[i].setSelected(true);
            else tBtns_en_ru[i].setSelected(false);
            if (!btn_up.isSelected()) tBtns_en_ru[i].setText(tBtns_en_ru[i].getText().toLowerCase());
        }
        if (!en_ru) for (ToggleButton tb : tBtns_ru) tb.setVisible(false);
        else {
            for (int i = 0; i < 6; i++) {
                if (btnState_ru[i][btn_up.isSelected()?1:0]) tBtns_ru[i].setSelected(true);
                else tBtns_ru[i].setSelected(false);
                tBtns_ru[i].setVisible(true);
            }
            if (!btn_up.isSelected()) for (ToggleButton tb : tBtns_ru) tb.setText(tb.getText().toLowerCase());
            else for (ToggleButton tb : tBtns_ru) tb.setText(tb.getText().toUpperCase());
        }
    }

    public void change_enRU() {
        if (btn_enRU.isSelected()) {
            //Pressed
            if (btn_up.isSelected()) change_save(1, 1);
            else change_save(1, 0);
            ru_en_text.setText("Кириллица");
            btn_enRU.setText("Ru");
            load_alph(true);
        } else {
            //Unpressed
            if (btn_up.isSelected()) change_save(0, 1);
            else change_save(0, 0);
            ru_en_text.setText("Латиница");
            btn_enRU.setText("En");
            load_alph(false);
        }
    }

    public void change_UP() {
        if (!btn_up.isSelected()) {
            btn_up.setSelected(true);
            return;
        }
        if (btn_enRU.isSelected()) {
            change_save(0, 0);

            load_alph(true);
        }
        else {
            change_save(1, 0);
            load_alph(false);
        }
        }

    public void change_LOW() {
        if (!btn_low.isSelected()) {
            btn_low.setSelected(true);
            return;
        }
        if (btn_enRU.isSelected()) {
            change_save(0, 1);
            load_alph(true);
        }
        else {
            change_save(1, 1);
            load_alph(false);

        }

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

    public void iWannaMySym() {
        if (mySym_T_F.isSelected()) {
            addUSym.setDisable(false);
            setUSym.setDisable(false);
            setOnlyMySym.setDisable(false);
            btn_UpCase.setDisable(false);
            btn_LowCase.setDisable(false);
            btn_OnlyMyCase.setDisable(false);
        } else {
            addUSym.setDisable(true);
            setUSym.setDisable(true);
            setOnlyMySym.setDisable(true);
            btn_UpCase.setDisable(true);
            btn_LowCase.setDisable(true);
            btn_OnlyMyCase.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> btnOK.requestFocus());
        InitArrays();
        for (ToggleButton tb : tBtns_en_ru) tb.setSelected(true);

    }
}
