package com.sergeineretin.shift;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFiltering {
    private ArrayList<Integer> integers = new ArrayList<Integer>();
    private ArrayList<Double> doubles = new ArrayList<Double>();
    private ArrayList<String> strings = new ArrayList<String>();
    private Command command;
    public FileFiltering(final String[] args) {
        command = new Command(args);
    }
    public void execute() {
        filterDataFromFiles();
        System.out.println();
    }

    private void filterDataFromFiles() {
        for (Path path
                : command.getFilenames()) {
              List<String> dataFromFile = readDataFromFile(path);
              filterData(dataFromFile);
        }

    }

    private void filterData(final List<String> dataFromFile) {
        for (String data
                : dataFromFile) {
            addDataToSuitableList(data);
        }
    }

    private void addDataToSuitableList(final String data) {
        try {
            addDataToNumberTypeLists(data);
        } catch (NumberFormatException e) {
            strings.add(data);
        }
    }

    private void addDataToNumberTypeLists(final String data) throws NumberFormatException {
        double value = Double.parseDouble(data);
        if (value % 1 == 0.0 && Integer.MAX_VALUE >= value && Integer.MIN_VALUE <= value) {
            integers.add((int) value);
        } else {
            doubles.add(value);
        }
    }


    private List<String> readDataFromFile(final Path path) {
        List<String> dataFromFile = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                 dataFromFile.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dataFromFile;
    }

}
