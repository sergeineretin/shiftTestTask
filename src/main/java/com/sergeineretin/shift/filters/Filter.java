package com.sergeineretin.shift.filters;

public interface Filter {
    void apply(String data);
    void close();
}
