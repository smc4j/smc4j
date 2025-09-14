package org.smc4j.core.poi;

import java.util.ArrayList;
import java.util.List;
import org.smc4j.core.constant.PointOfInterestType;
import org.smc4j.core.util.SwingUtil;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;

public class ZoneDetector implements PointOfInterestDetector<List<Poi>> {
    @Override
    public List<Poi> find(List<Candle> candles, int length, int count) {
        if (candles == null || candles.isEmpty()) {
            return List.of();
        }
        List<Poi> pois = new ArrayList<>();

        pois.addAll(SwingUtil.swingLows(candles, length).stream()
                .map(idx -> toPOI(candles.get(idx)))
                .limit(count > 0 ? count : Long.MAX_VALUE)
                .toList());

        pois.addAll(SwingUtil.swingHighs(candles, length).stream()
                .map(idx -> toPOI(candles.get(idx)))
                .limit(count > 0 ? count : Long.MAX_VALUE)
                .toList());

        return pois;
    }

    private Poi toPOI(Candle candle) {
        return new Poi(
                candle.getTimestamp(),
                candle.getOpen(),
                candle.getHigh(),
                candle.getLow(),
                candle.getClose(),
                PointOfInterestType.ZONE);
    }
}
