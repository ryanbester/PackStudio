package com.ryanbester.packstudio.gui.welcomescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WelcomeScreenController implements Initializable {

    static class RecentProjectCell extends ListCell<RecentProject> {
        Label name;
        Label path;
        Pane spacer;
        Button removeBtn;
        VBox content;
        HBox row;

        public RecentProjectCell() {
            name = new Label();
            path = new Label();
            spacer = new Pane();
            removeBtn = new Button("X");
            content = new VBox();
            row = new HBox();

            name.setFont(new Font("System", 18));

            removeBtn.getStyleClass().add("recent-remove-button");
            removeBtn.setOnAction(event -> getListView().getItems().remove(getItem()));

            content.getChildren().addAll(name, path);
            row.getChildren().addAll(content, spacer, removeBtn);
            row.setAlignment(Pos.CENTER);
            HBox.setHgrow(spacer, Priority.ALWAYS);
        }

        @Override
        protected void updateItem(RecentProject item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                name.setText(item.getName());
                path.setText(item.getPath());

                setText(null);
                setGraphic(row);
            }
        }
    }

    @FXML private ListView<RecentProject> recentProjects;

    @FXML private ImageView imgLogo;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        recentProjects.getItems().addAll(new RecentProject("Test", "/home/username/test/test.psp"),
            new RecentProject("Minecraft", "/home/username/minecraft/pack.psp"));
        recentProjects.setCellFactory(param -> new RecentProjectCell());

        imgLogo.setImage(new Image("/assets/icon256.png"));
    }
}
