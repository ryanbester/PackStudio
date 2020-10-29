package com.ryanbester.packstudio;

import com.ryanbester.packstudio.gui.preloader.PackStudioPreloader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));

        primaryStage.setTitle("PackStudio");
        primaryStage.getIcons().add(new Image("/assets/icon256.png"));

        Scene mainScene = new Scene(root, 600, 500);
        mainScene.getStylesheets()
            .add(getClass().getResource("/styles/style.css").toExternalForm());
        primaryStage.setScene(mainScene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "PackStudio");
        System.setProperty("javafx.preloader", PackStudioPreloader.class.getCanonicalName());
        launch(args);
    }
}
