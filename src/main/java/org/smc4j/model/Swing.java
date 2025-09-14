package org.smc4j.model;

public class Swing extends BasePoi {

    public Swing(long timestamp, double open, double high, double low, double close, boolean isHigh) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.isHigh = isHigh;
    }

    public Swing() {}

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

    public boolean isHigh() {
        return isHigh;
    }

    public boolean isLow() {
        return !isHigh;
    }

    @Override
    public String toString() {
        return (isHigh ? "Swing High" : "Swing Low") + " [timestamp=" + timestamp + ", open=" + open + ", high=" + high
                + ", low=" + low + ", close=" + close + "]";
    }
}
