package com.sergeineretin.shift.write;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileWrite implements Write {
    private BufferedOutputStream bufferedOutputStream;
    private FileOutputStream fileOutputStream;
    public FileWrite(final File file) {
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void write(final String data) {
        try {
            bufferedOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.write('\n');
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    public BufferedOutputStream getBufferedOutputStream() {
        return bufferedOutputStream;
    }

    public FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }
}
