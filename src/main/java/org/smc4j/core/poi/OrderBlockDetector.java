package org.smc4j.core.poi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import org.smc4j.core.constant.PointOfInterestType;
import org.smc4j.core.util.SwingUtil;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;

/**
 * Detects Order Blocks (bullish/bearish) from swing highs and lows.
 */
public class OrderBlockDetector implements PointOfInterestDetector<List<Poi>> {

    @Override
    public List<Poi> find(List<Candle> candles, int length, int count) {
        if (candles == null || candles.isEmpty() || length < 1) {
            return Collections.emptyList();
        }

        int n = candles.size();
        if (n < (length * 2 + 1)) {
            return Collections.emptyList();
        }

        List<Poi> pois = new ArrayList<>();

        // Bearish order blocks (swing lows)
        addPOIs(candles, SwingUtil.swingLows(candles, length), pois, (open, close) -> close < open, count);

        // Bullish order blocks (swing highs)
        addPOIs(candles, SwingUtil.swingHighs(candles, length), pois, (open, close) -> close > open, count);

        if (count > 0 && pois.size() > count) {
            return Collections.unmodifiableList(new ArrayList<>(pois.subList(0, count)));
        }
        return Collections.unmodifiableList(pois);
    }

    private void addPOIs(
            List<Candle> candles,
            List<Integer> indices,
            List<Poi> pois,
            BiPredicate<Double, Double> condition,
            int poiCount) {

        pois.addAll(indices.stream()
                .filter(idx -> idx > 0 && idx < candles.size())
                .map(idx -> candles.get(idx - 1))
                .filter(prev -> condition.test(prev.getOpen(), prev.getClose()))
                .limit(poiCount > 0 ? poiCount : Long.MAX_VALUE)
                .map(prev -> new Poi(
                        prev.getTimestamp(),
                        prev.getOpen(),
                        prev.getHigh(),
                        prev.getLow(),
                        prev.getClose(),
                        PointOfInterestType.ORDER_BLOCK))
                .toList());
    }
}
