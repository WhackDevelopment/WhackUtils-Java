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

package com.whackdevelopment.utils.tests;

import com.google.common.base.Preconditions;
import com.whackdevelopment.utils.WhackUtils;
import com.whackdevelopment.utils.terminal.TerminalColor;
import com.whackdevelopment.utils.math.MathUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * WhackUtils; com.whackdevelopment.utils.tests:TesterMain
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
public class TesterMain {


    private static int success = 0, error = 0;

    private static List<Supplier<String>> tests = new ArrayList<>();
    private static List<String> passed = new ArrayList<>();
    private static List<String> failed = new ArrayList<>();

    public static void main(String[] args) {
        log("===================== TESTS =====================");
        // ================================================= TESTS ================================================= //

        // ========================= Preconditions checks ========================= //
        tests.add(() -> {
            Preconditions.checkNotNull("null");
            return "fail-test-test";
        });

        // ========================= WhackUtils ========================= //
        tests.add(() -> {
            Preconditions.checkNotNull(WhackUtils.getInstance());
            return "WhackUtils#getInstance() 1st call";
        });
        tests.add(() -> {
            Preconditions.checkNotNull(WhackUtils.getInstance());
            return "WhackUtils#getInstance() 2nd call";
        });

        // ========================= WhackUtils ========================= //
        tests.add(() -> {
            String version = WhackUtils.getInstance().getVersion();
            Preconditions.checkArgument(version.equals("unknown"));
            return "WhackUtils#getInstance#getVersion()";
        });

        // ========================= MathUtils ========================= //
        tests.add(() -> {
            int gens = 10;
            int len = 15;
            List<String> randomNumberStrings = new ArrayList<>();
            for (int i = 0; i < gens; i++) {
                randomNumberStrings.add(MathUtils.getRandomNumberString(len));
            }
            randomNumberStrings.forEach(randomDigitsString -> {
                Preconditions.checkArgument(randomDigitsString.length() == len);
            });
            return "MathUtils#getRandomNumberString() Gens: " + gens;
        });

        // ========================= MathUtils ========================= //
        tests.add(() -> {
            int gens = 10000;
            int min = 150;
            int max = 99999;
            List<Integer> randomMinMaxInts = new ArrayList<>();
            for (int i = 0; i < gens; i++) {
                randomMinMaxInts.add(MathUtils.randomMinMax(min, max));
            }
            randomMinMaxInts.forEach(randomMinMax -> {
                Preconditions.checkArgument((randomMinMax > min && randomMinMax < max));
            });

            return "MathUtils#randomMinMax() Gens: " + gens;
        });


        // ================================================= TESTS ================================================= //
        tests.forEach(test -> {
            try {
                long milliStart = System.nanoTime();
                String s = test.get();
                long milliStop = System.nanoTime();
                passed.add(TerminalColor.wrapGreen(s) + TerminalColor.wrapBlue(" -> Finished in: " + MathUtils.nanosecondsToMilliseconds((milliStop - milliStart)) + " ms."));
                success++;
            } catch (Exception exception) {
                error++;
                failed.add(TerminalColor.wrapLightRed("[\n" + String.join(",\n", String.valueOf(exception.getStackTrace()[0]), String.valueOf(exception.getStackTrace()[1])) + "\n]"));
            }
        });

        log("================== TESTS PASSED ==================");
        log("Passed Tests: [\n" + String.join(",\n", passed) + "\n]");

        if (failed.size() > 0) {
            log("================== TESTS FAILED ==================");
            log("Failed Tests: [\n" + String.join(",\n", failed) + "\n]");
        }

        log("===================== TESTS =====================");
        log("Tests Finished [success=%d error=%d]", success, error);
        log("===================== TESTS =====================");
    }

    private static void log(String message, Object... args) {
        System.out.println(TerminalColor.wrapCyan(String.format(message, args)));
    }

    private static void log(String message) {
        System.out.println(TerminalColor.wrapCyan(String.format(message)));
    }

}
