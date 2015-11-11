package GetPassword.Settings_package;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static javafx.application.Platform.runLater;

/**
 * Created by deadboy on 09.11.15.
 */
public class SettingsWindow {
    private static boolean created = false;
    private static Stage settingsStage;
    private static AnchorPane mainAnchorPane;

    public SettingsWindow(AnchorPane mainAnchorPane) throws IOException {
        if (created) {
            settingsStage.show();
        } else {
            this.mainAnchorPane = mainAnchorPane;
            created = true;
            settingsStage = new Stage();
            Parent settingsRoot = new FXMLLoader().load(getClass().getResource("settingsWindow.fxml"));
            Scene scene = new Scene(settingsRoot, 800, 350);
            settingsStage.setScene(scene);
            settingsStage.setTitle("Settings");
            settingsStage.setResizable(false);
            settingsStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) runLater(settingsStage::requestFocus);
            });
            settingsStage.show();
            mainAnchorPane.setDisable(true);
            settingsStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
                mainAnchorPane.setDisable(false);
                settingsStage.close();
            });
        }
    }

    public SettingsWindow() {

    }

    Stage GetStage() {
        return settingsStage;
    }

    AnchorPane GetPane() {
        return mainAnchorPane;
    }
}
