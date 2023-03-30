/*
 * Copyright (c) 2023 - present | LuciferMorningstarDev <contact@lucifer-morningstar.xyz>
 * Copyright (c) 2023 - present | whackdevelopment.com <contact@whackdevelopment.com>
 * Copyright (c) 2023 - present | whackdevelopment.com team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.whackdevelopment.utils.math;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * WhackUtils; com.whackdevelopment.utils.math:MathUtils
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtils {

    private static final Random random = new Random();

    /**
     * generate a random {@link Integer} between 2 given numbers
     *
     * @param min minimum value of random {@link Integer}
     * @param max maximum value of random {@link Integer}
     * @return the random generated {@link Integer}
     * @since 30.03.2023
     */
    public static int randomMinMax(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min must be greater than max");
        }
        return random.nextInt(max + 1 - min) + min;
    }

    /**
     * round a {@link Double} HALF_UP
     *
     * @param value {@link Double} to round half up
     * @return rounded {@link Double}
     * @since 30.03.2023
     */
    public static double roundDouble2Places(double value) {
        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        double salary = bd.doubleValue();
        return Double.valueOf(salary);
    }

    /**
     * round a {@link Double} to 2 decimals
     *
     * @param value {@link Double} to round
     * @return rounded {@link Double}
     * @since 30.03.2023
     */
    public static double round2Decimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * generate a random number {@link String}
     *
     * @param length the length of the number string to generate
     * @return random number {@link String}
     * @since 30.03.2023
     */
    public static String getRandomNumberString(int length) {
        String validChars = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * validChars.length());
            sb.append(validChars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * convert nanoseconds to milliseconds
     * @param nanoseconds
     * @return rounded milliseconds
     */
    public static double nanosecondsToMilliseconds(long nanoseconds) {
        double milliseconds = nanoseconds / 1_000_000;
        return Math.round(milliseconds * 1000.0) / 1000.0;
    }

}
