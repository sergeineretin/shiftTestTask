package com.sergeineretin.shift.filters;

import com.sergeineretin.shift.Command;
import com.sergeineretin.shift.write.FileWrite;

import java.io.File;
import java.io.IOException;

public class StringsFilter implements Filter {
    private FileWrite fileWrite;


    public StringsFilter(final Command command) {
        String pathName = command.getPath().toString() + "\\"
                + command.getPrefix() +  "strings.txt";

        fileWrite = new FileWrite(new File(pathName));
    }

    @Override
    public void apply(final String data) {
        if (!data.toUpperCase().matches(INTEGERS_REGEX) && !data.toUpperCase().matches(DOUBLES_REGEX)
                && !data.isEmpty()) {
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
