package com.ryanbester.packstudio.gui.welcomescreen;

import javafx.beans.property.SimpleStringProperty;

public class RecentProject {

    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty path = new SimpleStringProperty("");

    public RecentProject() {
        this("", "");
    }

    public RecentProject(String name, String path) {
        setName(name);
        setPath(path);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path.set(path);
    }
}
