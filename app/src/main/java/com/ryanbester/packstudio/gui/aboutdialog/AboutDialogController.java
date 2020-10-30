package com.ryanbester.packstudio.gui.aboutdialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutDialogController implements Initializable {

    public static void showAboutDialog() {
        try {
            Parent root = FXMLLoader.load(AboutDialogController.class.getResource("/fxml/about.fxml"));
            Stage stage = new Stage();
            stage.setTitle("About PackStudio");

            Scene aboutScene = new Scene(root, 300, 200);
            aboutScene.getStylesheets()
                .add(AboutDialogController.class.getResource("/styles/style.css").toExternalForm());
            stage.setScene(aboutScene);

            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
