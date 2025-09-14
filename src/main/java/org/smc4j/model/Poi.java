package org.smc4j.model;

import org.smc4j.core.constant.PointOfInterestType;

public class Poi extends BasePoi {
    private PointOfInterestType type;

    public Poi(long timestamp, double open, double high, double low, double close, PointOfInterestType type) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.type = type;
    }

    public Poi() {}

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

    public PointOfInterestType getType() {
        return type;
    }

    public static Poi of() {
        return new Poi();
    }

    public static Poi of(Poi poi) {
        return new Poi(poi.timestamp, poi.open, poi.high, poi.low, poi.close, poi.type);
    }
}
