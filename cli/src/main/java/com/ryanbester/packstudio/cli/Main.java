package com.ryanbester.packstudio.cli;

import com.ryanbester.packstudio.cli.command.ICommand;
import com.ryanbester.packstudio.cli.command.ProjectCommand;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            printHelpMessage();
            System.exit(0);
        }

        ICommand cmdObj = null;
        switch (args[0]) {
            case "project":
                cmdObj = new ProjectCommand();
                break;
        }

        if (cmdObj == null) {
            printHelpMessage();
            System.exit(0);
        }

        if (!cmdObj.executeCommand(args)) {
            printHelpMessage();
            System.exit(0);
        }
    }

    public static void printHelpMessage() {
        StringBuilder message = new StringBuilder();
        message.append("Usage: PackStudioCLI.jar [command] [options]\n");
        message.append("Commands\n");
        message.append("=================================\n");
        message.append("Project\n");
        message.append("---------------------------------\n");
        message.append("project new:\tCreates a new project\n");

        System.out.print(message.toString());
    }
}
