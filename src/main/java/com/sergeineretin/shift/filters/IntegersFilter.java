package com.sergeineretin.shift.filters;

import com.sergeineretin.shift.Command;
import com.sergeineretin.shift.write.FileWrite;

import java.io.File;
import java.io.IOException;

public class IntegersFilter implements Filter {
    private FileWrite fileWrite;
    public IntegersFilter(final Command command) {
        String pathName = command.getPath().toString() + "\\"
                    + command.getPrefix() + "integers.txt";

        fileWrite = new FileWrite(new File(pathName));
    }

    @Override
    public void apply(final String data) {
        if (data.matches(INTEGERS_REGEX)) {
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
