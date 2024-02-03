package com.sergeineretin.shift;

public class Options {
    private static String statisticsFull = "-f";
    private static String statisticsSimple = "-s";
    private static String pathOfResults = "-o";
    private static String prefix = "-p";

    public static boolean isOption(final String string) {
        return string.equals(statisticsFull)
                || string.equals(statisticsSimple)
                || string.equals(pathOfResults)
                || string.equals(prefix);
    }

    public static String getStatisticsFull() {
        return statisticsFull;
    }

    public static String getStatisticsSimple() {
        return statisticsSimple;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getPathOfResults() {
        return pathOfResults;
    }
}
