package com.sergeineretin.shift;

public class ShiftTestTask {
    public static void main(final String[] args) {
        FileFiltering fileFiltering = new FileFiltering(args);
        fileFiltering.execute();
    }
}
