package org.smc4j.core.poi;

import java.util.List;
import org.smc4j.model.Candle;

public interface PointOfInterestDetector<T> {
    T find(List<Candle> candles, int length, int count);
}
