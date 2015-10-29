//: GetPassword/Main.java

package GetPassword;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/** This program generates a password , according to the end-user settings
 * @author deadboy
 * @author leo13pard@ya.ru
 * @version 1.0
 */

public class Main extends Application {
    /** Creating a window.*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("Password4Me");
        primaryStage.setScene(new Scene(root, 550, 240));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("ic2.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
///:~

//Счетчик сгенерированных паролей
//Размер окна через String args