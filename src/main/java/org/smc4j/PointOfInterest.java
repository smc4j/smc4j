package org.smc4j;

import java.util.Map;
import org.smc4j.core.constant.PointOfInterestType;
import org.smc4j.core.poi.FairValueGapDetector;
import org.smc4j.core.poi.OrderBlockDetector;
import org.smc4j.core.poi.PointOfInterestDetector;
import org.smc4j.core.poi.SwingDetector;
import org.smc4j.core.poi.ZoneDetector;

public class PointOfInterest {

    private final Map<PointOfInterestType, PointOfInterestDetector<?>> poiDetectorFactory;

    public PointOfInterest() {
        this.poiDetectorFactory = Map.of(
                PointOfInterestType.ORDER_BLOCK, new OrderBlockDetector(),
                PointOfInterestType.ZONE, new ZoneDetector(),
                PointOfInterestType.FAIR_VALUE_GAP, new FairValueGapDetector(),
                PointOfInterestType.SWING, new SwingDetector());
    }

    public PointOfInterestDetector<?> poi(PointOfInterestType type) {
        return this.poiDetectorFactory.get(type);
    }
}
