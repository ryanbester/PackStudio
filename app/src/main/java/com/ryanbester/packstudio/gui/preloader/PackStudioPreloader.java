package com.ryanbester.packstudio.gui.preloader;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.ImageIcon;

public class PackStudioPreloader extends Preloader implements Initializable {

    private Scene preloaderScene;
    private Stage preloaderStage;

    private Parent root;

    private final ProgressBar progressBar;

    @FXML private VBox vBox;
    @FXML private ImageView imgLogo;

    public PackStudioPreloader() {
        progressBar = new ProgressBar();
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        imgLogo.setImage(new Image("/assets/icon256.png"));
        vBox.getChildren().add(progressBar);
        progressBar.setPadding(new Insets(20, 20, 0, 20));
        progressBar.setMaxWidth(Double.MAX_VALUE);
    }

    @Override
    public void init() throws Exception {
        root = FXMLLoader.load(getClass().getResource("/fxml/preloader.fxml"));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                preloaderScene = new Scene(root, 600, 350);
                preloaderScene.getStylesheets().add(
                    PackStudioPreloader.class.getResource("/styles/style.css").toExternalForm());
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MacNatives.prepareMacApp();
        com.sun.glass.ui.Application.GetApplication().setName("PackStudio");

        preloaderStage = primaryStage;
        preloaderStage.setScene(preloaderScene);
        preloaderStage.getIcons().add(new Image("/assets/icon256.png"));

        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
    }

    @Override
    public void handleProgressNotification(ProgressNotification info) {
        progressBar.setProgress(info.getProgress());
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if (info.getType() == Type.BEFORE_START) {
            preloaderStage.hide();
        }
    }
}
