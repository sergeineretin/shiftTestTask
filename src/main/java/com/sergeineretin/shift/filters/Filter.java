package com.sergeineretin.shift.filters;

public interface Filter {
    String INTEGERS_REGEX = "^\\d+$";
    String DOUBLES_REGEX = "[-+]?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)([eE][-+]?[0-9]+)?";
    void apply(String data);
    void close();
}
