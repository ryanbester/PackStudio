package com.ryanbester.packstudio.lib.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanbester.packstudio.lib.project.file.ProjectFile;
import java.io.File;
import java.io.FileWriter;

public class Project {

    private File file;

    private ProjectFile projectFile;

    public Project(File file) {
        this.file = file;
    }

    public void saveProject() throws Exception {
        File packDir = new File(file.getParentFile(), "pack");
        if (!packDir.exists()) {
            if (!packDir.mkdirs()) {
                throw new Exception("Unable to create pack directory.");
            }
        }

        File templatesDir = new File(file.getParentFile(), "templates");
        if (!templatesDir.exists()) {
            if (!templatesDir.mkdirs()) {
                throw new Exception("Unable to create templates directory.");
            }
        }

        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

        FileWriter writer = new FileWriter(file);
        writer.write(gson.toJson(projectFile));
        writer.close();
    }

    public static Project loadProject(File file) throws Exception {
        return null;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ProjectFile getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(ProjectFile projectFile) {
        this.projectFile = projectFile;
    }
}
