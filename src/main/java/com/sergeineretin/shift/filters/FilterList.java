package com.sergeineretin.shift.filters;

import java.util.ArrayList;
import java.util.List;

public class FilterList implements Filter {
    private final List<Filter> filters = new ArrayList<>();
    public void apply(final String data) {
        filters.forEach(filter -> filter.apply(data));
    }
    public void add(final Filter filter) {
        filters.add(filter);
    }
    public void close() {
        filters.forEach(filter -> filter.close());
    }
}
