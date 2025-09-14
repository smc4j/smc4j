package org.smc4j;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smc4j.common.TestSetup;
import org.smc4j.core.constant.PointOfInterestType;
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
