/*
 * Copyright 2025 smc4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smc4j.poi;

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
