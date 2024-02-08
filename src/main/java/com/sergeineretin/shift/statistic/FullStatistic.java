package com.sergeineretin.shift.statistic;

public class FullStatistic extends Statistic {
    private double minDouble = Double.MAX_VALUE;
    private double maxDouble = Double.MIN_VALUE;
    private long minInteger = Long.MAX_VALUE;
    private long maxInteger = Long.MIN_VALUE;
    private int minString = Integer.MAX_VALUE;
    private int maxString = Integer.MIN_VALUE;
    private int numberOfIntegers = 0;
    private int numberOfDoubles = 0;
    private int numberOfStrings = 0;

    @Override
    public void update(final long data) {
        numberOfIntegers++;
        if (data <= minInteger) {
            minInteger = data;
        }
        if (data >= maxInteger) {
            maxInteger = data;
        }
    }

    @Override
    public void update(final double data) {
        numberOfDoubles++;
        if (data <= minDouble) {
            minDouble = data;
        }
        if (data >= maxDouble) {
            maxDouble = data;
        }
    }

    @Override
    public void update(final String data) {
        numberOfStrings++;
        if (data.length() < minString) {
            minString = data.length();
        }
        if (data.length() >= maxString) {
            maxString = data.length();
        }
    }

    @Override
    public String toString() {
        String message = "";
        if (numberOfStrings > 0) {
            message += "strings: number = " + numberOfStrings
                    + ", max = " + maxString + ", min = " + minString + "\n";
        }
        if (numberOfDoubles > 0) {
            message += "doubles: number = " + numberOfDoubles
                    + ", max = " + maxDouble + ", min = " + minDouble + "\n";
        }
        if (numberOfIntegers > 0) {
            message += "integers: number = " + numberOfIntegers
                    + ", max = " + maxInteger + ", min = " + minInteger + "\n";
        }
        return message;
    }

    public int getNumberOfDoubles() {
        return numberOfDoubles;
    }

    public int getNumberOfIntegers() {
        return numberOfIntegers;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }
}
