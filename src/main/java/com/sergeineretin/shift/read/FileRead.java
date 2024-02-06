package com.sergeineretin.shift.read;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileRead implements Read {
    private BufferedReader bufferedReader;
    private FileInputStream fileInputStream;
    public FileRead(final File file) {
        try {
            fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String read() {
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return line;
    }
    public void close() {
        try {
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }
}
