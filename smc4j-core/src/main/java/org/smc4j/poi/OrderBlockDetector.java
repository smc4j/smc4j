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
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import org.smc4j.constant.PointOfInterestType;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;
import org.smc4j.util.SwingUtil;

/** Detects Order Blocks (bullish/bearish) from swing highs and lows. */
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
