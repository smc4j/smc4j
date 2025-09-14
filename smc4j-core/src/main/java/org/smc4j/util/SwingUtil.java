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
package org.smc4j.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.smc4j.model.Candle;

public class SwingUtil {

    public static List<Integer> swingHighs(List<Candle> data, int length) {
        return detectSwings(data, length, (center, neighbor) -> center > neighbor, Candle::getHigh);
    }

    public static List<Integer> swingLows(List<Candle> data, int length) {
        return detectSwings(data, length, (center, neighbor) -> center < neighbor, Candle::getLow);
    }

    private static List<Integer> detectSwings(
            List<Candle> data, int length, BiPredicate<Double, Double> comparator, Function<Candle, Double> extractor) {

        int n = data.size();

        if (n < 2 * length + 1) return List.of();

        double[] values = data.stream().mapToDouble(extractor::apply).toArray();

        List<Integer> swings = new ArrayList<>();

        for (int i = length; i < n - length; i++) {
            double center = values[i];

            boolean isSwing = true;
            for (int offset = 1; offset <= length; offset++) {
                if (!comparator.test(center, values[i - offset]) || !comparator.test(center, values[i + offset])) {
                    isSwing = false;
                    break;
                }
            }

            if (isSwing) swings.add(i);
        }

        return swings;
    }
}
