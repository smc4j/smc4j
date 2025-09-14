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
import java.util.List;
import org.smc4j.constant.PointOfInterestType;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;
import org.smc4j.util.SwingUtil;

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
