package com.sergeineretin.shift;

import com.sergeineretin.shift.filters.DoublesFilter;
import com.sergeineretin.shift.filters.FilterList;
import com.sergeineretin.shift.filters.IntegersFilter;
import com.sergeineretin.shift.filters.StringsFilter;
import com.sergeineretin.shift.read.FileRead;

import java.nio.file.Path;

public class FileFiltering {
    private final Command command;
    private FileRead fileRead;
    public FileFiltering(final String[] args) {
        command = new Command(args);
    }
    public void execute() {
        FilterList filter = genFilter();
        for (Path path : command.getFilenames()) {
            fileRead = new FileRead(path.toFile());
            writeStream(filter);
        }
        System.out.println(filter.getStatistic());
        filter.close();
    }

    private void writeStream(final FilterList filter) {
        try {
            String string;
            while ((string = fileRead.read()) != null) {
                filter.apply(string);
            }
        } finally {
            fileRead.close();
        }
    }
    private FilterList genFilter() {
        FilterList filterList = new FilterList(command.getStatisticsMode());
        filterList.add(new IntegersFilter(command));
        filterList.add(new DoublesFilter(command));
        filterList.add(new StringsFilter(command));
        return filterList;
    }

}
