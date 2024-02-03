package com.sergeineretin.shift;

public class Options {
    private static final String STATISTICS_FULL = "-f";
    private static final String STATISTICS_SIMPLE = "-s";
    private static final String PATH_OF_RESULTS = "-o";
    private static final String PREFIX = "-p";

    public static boolean isOption(final String string) {
        return string.equals(STATISTICS_FULL)
                || string.equals(STATISTICS_SIMPLE)
                || string.equals(PATH_OF_RESULTS)
                || string.equals(PREFIX);
    }

    public static String getStatisticsFull() {
        return STATISTICS_FULL;
    }

    public static String getStatisticsSimple() {
        return STATISTICS_SIMPLE;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static String getPathOfResults() {
        return PATH_OF_RESULTS;
    }
}
