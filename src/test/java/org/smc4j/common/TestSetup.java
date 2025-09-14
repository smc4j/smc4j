package org.smc4j.common;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.smc4j.core.constant.PointOfInterestType;
import org.smc4j.model.Candle;

public abstract class TestSetup {

    protected static Stream<Map.Entry<PointOfInterestType, List<Candle>>> ohlcCandleData() {
        return Stream.of(
                Map.entry(
                        PointOfInterestType.ORDER_BLOCK,
                        List.of(
                                new Candle(1L, 100, 102, 98, 101),
                                new Candle(2L, 101, 103, 99, 102),
                                new Candle(3L, 102, 104, 100, 103),
                                new Candle(4L, 103, 107, 102, 106),
                                new Candle(5L, 106, 110, 105, 109),
                                new Candle(6L, 108, 109, 104, 105),
                                new Candle(7L, 105, 106, 101, 102),
                                new Candle(8L, 102, 104, 100, 101),
                                new Candle(9L, 101, 108, 100, 107),
                                new Candle(10L, 107, 111, 106, 110),
                                new Candle(11L, 109, 110, 107, 108),
                                new Candle(12L, 108, 109, 105, 106),
                                new Candle(13L, 106, 115, 105, 114),
                                new Candle(14L, 114, 118, 113, 117),
                                new Candle(15L, 116, 117, 112, 113))),
                Map.entry(
                        PointOfInterestType.ZONE,
                        List.of(
                                new Candle(11L, 110, 112, 109, 111),
                                new Candle(12L, 111, 113, 110, 112),
                                new Candle(13L, 112, 115, 111, 114),
                                new Candle(14L, 114, 118, 113, 117),
                                new Candle(15L, 117, 120, 115, 116),
                                new Candle(16L, 116, 119, 112, 113),
                                new Candle(17L, 113, 114, 110, 111),
                                new Candle(18L, 111, 113, 109, 112),
                                new Candle(19L, 112, 115, 111, 114),
                                new Candle(20L, 114, 117, 113, 115))),
                Map.entry(
                        PointOfInterestType.FAIR_VALUE_GAP,
                        List.of(
                                new Candle(1L, 100, 102, 99, 101),
                                new Candle(2L, 101, 103, 100, 102),
                                new Candle(3L, 104, 106, 103, 105),
                                new Candle(4L, 110, 112, 109, 111),
                                new Candle(5L, 112, 113, 108, 109),
                                new Candle(6L, 107, 108, 105, 106),
                                new Candle(21L, 111, 118, 110, 117),
                                new Candle(22L, 117, 119, 115, 118),
                                new Candle(23L, 118, 121, 117, 120),
                                new Candle(24L, 120, 125, 119, 124),
                                new Candle(24L, 120, 125, 119, 124),
                                new Candle(25L, 124, 128, 123, 127),
                                new Candle(26L, 127, 130, 125, 129),
                                new Candle(27L, 129, 133, 128, 132),
                                new Candle(28L, 132, 134, 130, 133),
                                new Candle(29L, 133, 135, 131, 134),
                                new Candle(30L, 134, 137, 132, 136))),
                Map.entry(
                        PointOfInterestType.SWING,
                        List.of(
                                new Candle(1L, 100, 102, 98, 101),
                                new Candle(2L, 101, 103, 99, 102),
                                new Candle(3L, 102, 104, 100, 103),
                                new Candle(4L, 103, 107, 102, 106),
                                new Candle(5L, 106, 110, 105, 109),
                                new Candle(6L, 108, 109, 104, 105),
                                new Candle(7L, 105, 106, 101, 102),
                                new Candle(8L, 102, 104, 100, 101),
                                new Candle(9L, 101, 108, 100, 107),
                                new Candle(10L, 107, 111, 106, 110),
                                new Candle(11L, 109, 110, 107, 108),
                                new Candle(12L, 108, 109, 105, 106),
                                new Candle(13L, 106, 115, 105, 114),
                                new Candle(14L, 114, 118, 113, 117),
                                new Candle(15L, 116, 117, 112, 113))));
    }

    protected static Stream<Map.Entry<PointOfInterestType, List<Candle>>> ohlcCandleEmptyData() {
        return Stream.of(
                Map.entry(PointOfInterestType.ORDER_BLOCK, List.of()),
                Map.entry(PointOfInterestType.ZONE, List.of()),
                Map.entry(PointOfInterestType.FAIR_VALUE_GAP, List.of()),
                Map.entry(PointOfInterestType.SWING, List.of()));
    }
}
