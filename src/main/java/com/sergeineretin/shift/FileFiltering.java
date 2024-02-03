package com.sergeineretin.shift;

import java.util.ArrayList;

public class FileFiltering {
    private ArrayList<Integer> integers = new ArrayList<Integer>();
    private ArrayList<Double> doubles = new ArrayList<Double>();
    private ArrayList<String> strings = new ArrayList<String>();
    private Command command;
    public FileFiltering(final String[] args) {
        command = new Command(args);
    }
    public void execute() {
        command.getPath();
        command.getPrefix();
    }

}
