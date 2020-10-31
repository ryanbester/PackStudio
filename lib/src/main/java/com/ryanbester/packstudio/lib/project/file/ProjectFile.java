package com.ryanbester.packstudio.lib.project.file;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

public class ProjectFile {

    @Expose private String name;

    @Expose private int version;

    @Expose private List<ProjectFileTemplate> templates = new ArrayList<>();

    @Expose private ProjectFilePaths paths;

    public ProjectFile() {

    }

    public ProjectFile(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<ProjectFileTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<ProjectFileTemplate> templates) {
        this.templates = templates;
    }

    public ProjectFilePaths getPaths() {
        return paths;
    }

    public void setPaths(ProjectFilePaths paths) {
        this.paths = paths;
    }
}
