package com.sergeineretin.shift.filters;

import com.sergeineretin.shift.Command;
import com.sergeineretin.shift.write.FileWrite;

import java.io.File;
import java.io.IOException;

public class StringsFilter implements Filter {
    private FileWrite fileWrite;
    private final String integersRegex = "^\\d+$";
    private final String doublesRegex = "-?\\d+(\\.\\d+)?(E[+-]?\\d+)?";

    public StringsFilter(final Command command) {
        String pathName = command.getPath().toString() + command.getPrefix() + "strings.txt";
        fileWrite = new FileWrite(new File(pathName));
    }

    @Override
    public void apply(final String data) {
        if (!data.toUpperCase().matches(integersRegex) && !data.toUpperCase().matches(doublesRegex)) {
            fileWrite.write(data);
        }
    }
    public void close() {
        try {
            fileWrite.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public FileWrite getFileWrite() {
        return fileWrite;
    }
}
