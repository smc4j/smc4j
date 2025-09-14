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

import java.util.Map;
import org.smc4j.constant.PointOfInterestType;
import org.smc4j.poi.FairValueGapDetector;
import org.smc4j.poi.OrderBlockDetector;
import org.smc4j.poi.PointOfInterestDetector;
import org.smc4j.poi.SwingDetector;
import org.smc4j.poi.ZoneDetector;

public class PointOfInterest {

    private final Map<PointOfInterestType, PointOfInterestDetector<?>> poiDetectorFactory;

    public PointOfInterest() {
        this.poiDetectorFactory = Map.of(
                PointOfInterestType.ORDER_BLOCK, new OrderBlockDetector(),
                PointOfInterestType.ZONE, new ZoneDetector(),
                PointOfInterestType.FAIR_VALUE_GAP, new FairValueGapDetector(),
                PointOfInterestType.SWING, new SwingDetector());
    }

    public PointOfInterestDetector<?> poi(PointOfInterestType type) {
        return this.poiDetectorFactory.get(type);
    }
}
