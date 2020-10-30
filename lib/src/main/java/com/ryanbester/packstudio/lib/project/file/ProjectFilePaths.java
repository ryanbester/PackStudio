package com.ryanbester.packstudio.lib.project.file;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

public class ProjectFilePaths {

    @Expose private List<ProjectFilePath> blockstates = new ArrayList<>();
    @Expose private List<ProjectFilePath> models = new ArrayList<>();
    @Expose private List<ProjectFilePath> textures = new ArrayList<>();

    public List<ProjectFilePath> getBlockstates() {
        return blockstates;
    }

    public void setBlockstates(
        List<ProjectFilePath> blockstates) {
        this.blockstates = blockstates;
    }

    public List<ProjectFilePath> getModels() {
        return models;
    }

    public void setModels(List<ProjectFilePath> models) {
        this.models = models;
    }

    public List<ProjectFilePath> getTextures() {
        return textures;
    }

    public void setTextures(List<ProjectFilePath> textures) {
        this.textures = textures;
    }
}
