package com.sergeineretin.shift.filters;

import com.sergeineretin.shift.Command;
import com.sergeineretin.shift.write.FileWrite;

import java.io.File;
import java.io.IOException;

public class DoublesFilter implements Filter {
    private FileWrite fileWrite;
    private final String regex = "-?\\d+(\\.\\d+)?(E[+-]?\\d+)?";
    private final String integersRegex = "^\\d+$";


    public DoublesFilter(final Command command) {
        String pathName = command.getPath().toString() + command.getPrefix() + "doubles.txt";
        fileWrite = new FileWrite(new File(pathName));
    }

    @Override
    public void apply(final String data) {
        if (data.toUpperCase().matches(regex) && !data.matches(integersRegex)) {
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
