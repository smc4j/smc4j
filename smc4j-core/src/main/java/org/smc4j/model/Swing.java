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

public class Swing extends BasePoi {

    public Swing(long timestamp, double open, double high, double low, double close, boolean isHigh) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.isHigh = isHigh;
    }

    public Swing() {}

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

    public boolean isHigh() {
        return isHigh;
    }

    public boolean isLow() {
        return !isHigh;
    }

    @Override
    public String toString() {
        return (isHigh ? "Swing High" : "Swing Low")
                + " [timestamp="
                + timestamp
                + ", open="
                + open
                + ", high="
                + high
                + ", low="
                + low
                + ", close="
                + close
                + "]";
    }
}
