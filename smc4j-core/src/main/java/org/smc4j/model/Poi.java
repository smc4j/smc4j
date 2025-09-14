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
package org.smc4j.model;

import org.smc4j.constant.PointOfInterestType;

public class Poi extends BasePoi {
    private PointOfInterestType type;

    public Poi(long timestamp, double open, double high, double low, double close, PointOfInterestType type) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.type = type;
    }

    public Poi() {}

    public long getTimestamp() {
        return timestamp;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public PointOfInterestType getType() {
        return type;
    }

    public static Poi of() {
        return new Poi();
    }

    public static Poi of(Poi poi) {
        return new Poi(poi.timestamp, poi.open, poi.high, poi.low, poi.close, poi.type);
    }
}
