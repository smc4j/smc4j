package org.smc4j.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.smc4j.model.Candle;

public class SwingUtil {

    public static List<Integer> swingHighs(List<Candle> data, int length) {
        return detectSwings(data, length, (center, neighbor) -> center > neighbor, Candle::getHigh);
    }

    public static List<Integer> swingLows(List<Candle> data, int length) {
        return detectSwings(data, length, (center, neighbor) -> center < neighbor, Candle::getLow);
    }

    private static List<Integer> detectSwings(
            List<Candle> data, int length, BiPredicate<Double, Double> comparator, Function<Candle, Double> extractor) {

        int n = data.size();
        if (n < 2 * length + 1) return List.of(); // not enough candles

        // Pre-extract values for faster access
        double[] values = data.stream().mapToDouble(extractor::apply).toArray();

        List<Integer> swings = new ArrayList<>();

        // Main loop
        for (int i = length; i < n - length; i++) {
            double center = values[i];

            // Check left and right neighbors in one loop
            boolean isSwing = true;
            for (int offset = 1; offset <= length; offset++) {
                if (!comparator.test(center, values[i - offset]) || !comparator.test(center, values[i + offset])) {
                    isSwing = false;
                    break;
                }
            }

            if (isSwing) swings.add(i);
        }

        return swings;
    }
}
