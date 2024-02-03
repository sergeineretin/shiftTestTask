package com.sergeineretin.shift;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Path;
import java.util.List;

public class Command {
    private Path path;
    private StatisticsMode statisticsMode;
    private String prefix;
    private ArrayList<Path> filenames = new ArrayList<>();
    private ArrayList<String> args;
    public Command(final String[] args) {
        this.args = new ArrayList<>(Arrays.stream(args).toList());
        setPath();
        setStatisticsMode();
        setPrefix();
        setFilenames();
    }

    private void setFilenames() {
        try {
            List<String> possibleFilenames = removeAllButFilenamesFromArgs();
            for (String filename
                    : possibleFilenames) {
                addFilename(filename);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    private List<String> removeAllButFilenamesFromArgs() throws IllegalArgumentException {
        args.remove(Options.getStatisticsSimple());
        args.remove(Options.getStatisticsFull());
        args.remove(Options.getPrefix());
        args.remove(Options.getPathOfResults());
        args.remove(path.toString());
        args.remove(prefix);
        if (args.isEmpty()) {
            throw new IllegalArgumentException("At least one file with source data must be specified.");
        }
        return args;
    }
    private void addFilename(final String filenameString) {
        try {
            Path path = Paths.get(filenameString);
            filenames.add(path);
        } catch (InvalidPathException e) {
            System.err.println(e);
        }
    }

    private void setPrefix() {
        if (isThereOptionOnCommand(Options.getPrefix())) {
            prefix = getStringFollowingOption(Options.getPrefix());
        } else {
            prefix = "";
        }
    }
    private void setStatisticsMode() {
        if (isThereOptionOnCommand(Options.getStatisticsFull())) {
            statisticsMode = StatisticsMode.full;
        } else {
            statisticsMode = StatisticsMode.simple;
        }
    }
    private void setPath() {
        String pathString = getStringOfPath();
        path = getValidatedPath(pathString);
    }
    private String getStringOfPath() {
        if (isThereOptionOnCommand(Options.getPathOfResults())) {
            return getStringFollowingOption(Options.getPathOfResults());
        } else {
            return "";
        }
    }

    private String getStringFollowingOption(final String option) {
        try {
            int optionIndex = args.indexOf(option);
            if (optionIndex == args.size() - 1) {
                throw new IllegalArgumentException("The option " + option
                        + " should be followed by a string.");
            } else if (Options.isOption(args.get(optionIndex + 1))) {
                throw new IllegalArgumentException("the argument following option " + option
                        + " must not be an option.");
            } else {
                return args.get(optionIndex + 1);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
        return "";
    }
    private  boolean isThereOptionOnCommand(final String option) {
        return args.contains(option);
    }
    private Path getValidatedPath(final String pathString) {
        try {
            return Paths.get(pathString);
        } catch (InvalidPathException e) {
            System.err.println(e);
        }
        return null;
    }
    public Path getPath() {
        return path;
    }
    public StatisticsMode getStatisticsMode() {
        return statisticsMode;
    }
    public String getPrefix()  {
        return prefix;
    }
    public List<Path> getFilenames() {
        return filenames;
    }
}
