package com.ryanbester.packstudio.lib.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanbester.packstudio.lib.project.file.ProjectFile;
import com.ryanbester.packstudio.lib.project.file.ProjectFilePaths;
import java.io.File;
import java.io.FileWriter;

public class Project {

    private File file;

    private ProjectFile projectFile;

    public Project(String filename) {
        this(filename, filename);
    }

    public Project(String filename, String name) {
        projectFile = new ProjectFile(name, 1);

        if (name.endsWith(".psp")) {
            projectFile.setName(name.substring(0, name.length() - 4));
        }

        projectFile.setPaths(new ProjectFilePaths());

        if (!filename.endsWith(".psp")) {
            this.file = new File(filename + ".psp");
        } else {
            this.file = new File(filename);
        }
    }

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
