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

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import org.smc4j.constant.PointOfInterestType;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;

public class FairValueGapDetector implements PointOfInterestDetector<List<Poi>> {

    private static final Integer CANDLE_SIZE = 3;

    @Override
    public List<Poi> find(List<Candle> candles, int length, int count) {
        if (candles == null || candles.size() < CANDLE_SIZE) {
            return List.of();
        }

        return IntStream.range(1, candles.size() - 1)
                .mapToObj(i -> createIfFVG(candles.get(i - 1), candles.get(i), candles.get(i + 1)))
                .filter(Objects::nonNull)
                .limit(count > 0 ? count : Long.MAX_VALUE)
                .toList();
    }

    private Poi createIfFVG(Candle prev, Candle curr, Candle next) {
        if (curr.getClose() > curr.getOpen() && prev.getHigh() < next.getLow()) {
            return new Poi(
                    curr.getTimestamp(),
                    curr.getOpen(),
                    next.getLow(),
                    prev.getHigh(),
                    curr.getClose(),
                    PointOfInterestType.FAIR_VALUE_GAP);
        } else if (curr.getClose() < curr.getOpen() && prev.getLow() > next.getHigh()) {
            return new Poi(
                    curr.getTimestamp(),
                    curr.getOpen(),
                    prev.getLow(),
                    next.getHigh(),
                    curr.getClose(),
                    PointOfInterestType.FAIR_VALUE_GAP);
        }
        return Poi.of();
    }
}
