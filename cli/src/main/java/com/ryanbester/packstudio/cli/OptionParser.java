package com.ryanbester.packstudio.cli;

import java.util.HashMap;
import java.util.Map;

public class OptionParser {

    public enum OptionType {
        PARAMETER,
        FLAG
    }

    private final Map<String, String> options = new HashMap<String, String>();

    public OptionParser(String[] args, Map<String, OptionType> optionTypes) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                // An option
                String optName = args[i].substring(1);

                // Remove other dash if two are use d.
                if (optName.startsWith("-")) {
                    optName = optName.substring(1);
                }

                // Option in format name=value
                if (optName.contains("=")) {
                    String[] parts = optName.split("=");
                    optName = parts[0];

                    OptionType optType = optionTypes.get(optName);
                    if (optType == null) {
                        throw new Exception("Unknown option: " + optName);
                    }

                    if (optType == OptionType.FLAG) {
                        throw new Exception(optName + " is a flag and does not need a value");
                    }

                    if (parts.length < 2) {
                        throw new Exception(optName + " argument does not have a value");
                    }
                    String optValue = parts[1];
                    options.put(optName, optValue);
                    continue;
                }

                OptionType optType = optionTypes.get(optName);
                if (optType == null) {
                    throw new Exception("Unknown option: " + optName);
                }

                if (optType == OptionType.FLAG) {
                    options.put(optName, "true");
                    continue;
                }

                // Option in format --name value
                if (i + 2 > args.length) {
                    throw new Exception(optName + " argument does not have a value");
                }

                String optValue = args[i + 1];
                // Value cannot start with dashes
                if (optValue.startsWith("-")) {
                    throw new Exception(optName + " argument does not have a value");
                }
                options.put(optName, optValue);
            }
        }
    }

    public String getOption(String name) {
        return options.get(name);
    }
}
