package com.sergeineretin.shift.filters;

import com.sergeineretin.shift.statistic.FullStatistic;
import com.sergeineretin.shift.statistic.SimpleStatistic;
import com.sergeineretin.shift.statistic.Statistic;
import com.sergeineretin.shift.StatisticsMode;

import java.util.ArrayList;
import java.util.List;

public class FilterList implements Filter {
    private final Statistic statistic;
    public FilterList(final StatisticsMode statisticsMode) {
        if (statisticsMode == StatisticsMode.full) {
            statistic = new FullStatistic();
        } else {
            statistic = new SimpleStatistic();
        }
    }
    private final List<Filter> filters = new ArrayList<>();
    public void apply(final String data) {
        filters.forEach(filter -> filter.apply(data));
        updateStatistics(data);
    }

    private void updateStatistics(final String data) {
        if (data.matches(INTEGERS_REGEX)) {
            statistic.update(Long.parseLong(data));
        }
        if (data.matches(DOUBLES_REGEX) && !data.matches(INTEGERS_REGEX)) {
            statistic.update(Double.parseDouble(data));
        }
        if (!data.matches(DOUBLES_REGEX) && !data.matches(INTEGERS_REGEX) && !data.isEmpty()) {
            statistic.update(data);
        }
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void add(final Filter filter) {
        filters.add(filter);
    }
    public void close() {
        filters.forEach(Filter::close);
    }
}
