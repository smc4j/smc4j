package org.smc4j.core.constant;

public enum PointOfInterestType {
    ORDER_BLOCK("Order Block"),
    FAIR_VALUE_GAP("Fair Value Gap"),
    LIQUIDITY_ZONE("Liquidity Zone"),
    ZONE("Zone"),
    IMBALANCE_ZONE("Imbalance Zone"),
    SWING("Swing");

    private final String value;

    PointOfInterestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
