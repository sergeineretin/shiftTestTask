package com.sergeineretin.shift.statistic;

public class SimpleStatistic extends Statistic {
    private int numberOfIntegers = 0;
    private int numberOfDoubles = 0;
    private int numberOfStrings = 0;
    @Override
    public void update(final long data) {
        numberOfIntegers++;
    }

    @Override
    public void update(final double data) {
        numberOfDoubles++;
    }

    @Override
    public void update(final String data) {
        numberOfStrings++;
    }

    @Override
    public String toString() {
        String message = "";
        if (numberOfStrings > 0) {
            message += "strings: number = " + numberOfStrings + "\n";
        }
        if (numberOfDoubles > 0) {
            message += "doubles: number = " + numberOfDoubles + "\n";
        }
        if (numberOfIntegers > 0) {
            message += "integers: number = " + numberOfIntegers + "\n";
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
