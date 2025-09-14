package org.smc4j.model;

public class Candle {
    private long timestamp;
    private double open;
    private double high;
    private double low;
    private double close;

    public Candle(long timestamp, double open, double high, double low, double close) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public Candle() {}

    public long getTimestamp() {
        return timestamp;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }
}
