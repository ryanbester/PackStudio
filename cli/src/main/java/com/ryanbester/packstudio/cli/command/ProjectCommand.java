package com.ryanbester.packstudio.cli.command;

import com.ryanbester.packstudio.cli.OptionParser;
import com.ryanbester.packstudio.cli.OptionParser.OptionType;
import com.ryanbester.packstudio.lib.project.Project;
import com.ryanbester.packstudio.lib.project.file.ProjectFile;
import com.ryanbester.packstudio.lib.project.file.ProjectFilePath;
import com.ryanbester.packstudio.lib.project.file.ProjectFilePaths;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectCommand implements ICommand {

    @Override
    public boolean executeCommand(String[] args) {
        if (args.length < 2) {
            return false;
        }

        switch (args[1]) {
            case "new":
                newProject(args);
                break;
            default:
                return false;
        }

        return true;
    }

    public void newProject(String[] args) {
        if (args.length < 3) {
            System.out.println("No project name specified");
            return;
        }

        System.out.println("Creating project with name: " + args[2]);

        try {
            Map<String, OptionType> optionTypes = new HashMap<>();
            optionTypes.put("name", OptionType.PARAMETER);
            optionTypes.put("templates", OptionType.PARAMETER);
            OptionParser optionParser = new OptionParser(args, optionTypes);

            String name = optionParser.getOption("name");

            Project project;
            if (name != null) {
                project = new Project(args[2], name);
            } else {
                project = new Project(args[2]);
            }

            project.saveProject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
