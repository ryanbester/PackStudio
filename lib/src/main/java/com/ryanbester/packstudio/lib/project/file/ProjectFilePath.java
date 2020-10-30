package com.ryanbester.packstudio.lib.project.file;

import com.google.gson.annotations.Expose;

public class ProjectFilePath {

    @Expose private String name;
    @Expose private String path;

    public ProjectFilePath(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
