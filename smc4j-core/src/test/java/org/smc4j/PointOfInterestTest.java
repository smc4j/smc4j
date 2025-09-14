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
package org.smc4j;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smc4j.common.TestSetup;
import org.smc4j.constant.PointOfInterestType;
import org.smc4j.model.Candle;
import org.smc4j.model.Poi;


@ExtendWith(MockitoExtension.class)
public class PointOfInterestTest extends TestSetup {

    @ParameterizedTest
    @MethodSource("ohlcCandleData")
    void testPointOfInterest(Map.Entry<PointOfInterestType, List<Candle>> input) {
        var poi = new PointOfInterest();
        List<Poi> poiZoneResult = (List<Poi>) poi.poi(input.getKey()).find(input.getValue(), 4, 4);
        Assertions.assertNotNull(poiZoneResult);
        Assertions.assertFalse(poiZoneResult.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("ohlcCandleData")
    void testPointOfInterest_empty_poi(Map.Entry<PointOfInterestType, List<Candle>> input) {
        var poi = new PointOfInterest();
        List<Poi> poiZoneResult = (List<Poi>) poi.poi(input.getKey()).find(input.getValue(), 8, 8);
        Assertions.assertNotNull(poiZoneResult);
        Assertions.assertTrue(poiZoneResult.size() <= 8);
    }

    @ParameterizedTest
    @MethodSource("ohlcCandleEmptyData")
    void testPointOfInterest_empty_candle(Map.Entry<PointOfInterestType, List<Candle>> input) {
        var poi = new PointOfInterest();
        List<Poi> poiZoneResult = (List<Poi>) poi.poi(input.getKey()).find(input.getValue(), 0, 0);
        Assertions.assertNotNull(poiZoneResult);
        Assertions.assertTrue(poiZoneResult.size() <= 7);
    }
}
