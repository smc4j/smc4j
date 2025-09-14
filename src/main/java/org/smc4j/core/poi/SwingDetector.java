package org.smc4j.core.poi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.smc4j.model.Candle;
import org.smc4j.model.Swing;

public class SwingDetector implements PointOfInterestDetector<List<Swing>> {

    @Override
    public List<Swing> find(List<Candle> candles, int length, int count) {
        if (candles == null || candles.isEmpty() || length < 1 || count < 0) {
            return new ArrayList<>();
        }

        List<Swing> swings = new ArrayList<>();
        swings.addAll(detectSwings(candles, length, true)); // swing highs
        swings.addAll(detectSwings(candles, length, false)); // swing lows

        return swings.stream()
                .sorted(Comparator.comparingLong(Swing::getTimestamp).reversed())
                .limit(count > 0 ? count : swings.size())
                .collect(Collectors.toList());
    }

    private List<Swing> detectSwings(List<Candle> candles, int length, boolean isHigh) {
        int n = candles.size();

        return IntStream.range(length, n - length)
                .mapToObj(i -> {
                    Candle candle = candles.get(i);
                    double value = isHigh ? candle.getHigh() : candle.getLow();

                    boolean isSwing = IntStream.rangeClosed(1, length).allMatch(j -> {
                        double prev = isHigh
                                ? candles.get(i - j).getHigh()
                                : candles.get(i - j).getLow();
                        double next = isHigh
                                ? candles.get(i + j).getHigh()
                                : candles.get(i + j).getLow();
                        return isHigh ? (prev < value && next < value) : (prev > value && next > value);
                    });

                    if (isSwing) {
                        return new Swing(
                                candle.getTimestamp(),
                                candle.getOpen(),
                                candle.getHigh(),
                                candle.getLow(),
                                candle.getClose(),
                                isHigh);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
