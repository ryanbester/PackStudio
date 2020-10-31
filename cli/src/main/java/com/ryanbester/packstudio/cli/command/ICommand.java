package com.ryanbester.packstudio.cli.command;

public interface ICommand {

    /**
     * Called when the command is to be executed.
     * @param args The command line arguments.
     * @return True if the command is found or false if the command does not exist.
     */
    boolean executeCommand(String[] args);

}
