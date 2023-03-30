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

package com.whackdevelopment.utils.time;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * WhackUtils; com.whackdevelopment.utils.time:TimeUtils
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {

    public static String formatTime(long timeInMillis) {
        long hours = TimeUnit.MILLISECONDS.toHours(timeInMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) - TimeUnit.HOURS.toMinutes(hours);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static String timePad(int number) {
        return String.format("%02d", number);
    }

    public static List<String> msToTimeStringsEnglish(long milliseconds) {
        int seconds = (int) Math.floor(milliseconds / 1000);
        int minutes = (int) Math.floor(seconds / 60);
        int hours = (int) Math.floor(minutes / 60);
        int days = (int) Math.floor(hours / 24);
        int months = (int) Math.floor(days / 30);
        int years = (int) Math.floor(days / 365);

        seconds %= 60;
        minutes %= 60;
        hours %= 24;
        days %= 30;
        months %= 12;

        List<String> result = new ArrayList<>();
        if (years > 0) {
            result.add(timePad(years) + " year(s)");
            result.add(timePad(months) + " month(s)");
            result.add(timePad(days) + " day(s)");
        } else if (months > 0) {
            result.add(timePad(months) + " month(s)");
            result.add(timePad(days) + " day(s)");
            result.add(timePad(hours) + " hour(s)");
        } else if (days > 0) {
            result.add(timePad(days) + " day(s)");
            result.add(timePad(hours) + " hour(s)");
            result.add(timePad(minutes) + " minute(s)");
        } else if (hours > 0) {
            result.add(timePad(hours) + " hour(s)");
            result.add(timePad(minutes) + " minute(s)");
            result.add(timePad(seconds) + " second(s)");
        } else if (minutes > 0) {
            result.add(timePad(minutes) + " minute(s)");
            result.add(timePad(seconds) + " second(s)");
        } else {
            result.add(timePad(seconds) + " second(s)");
        }
        return result;
    }

    public static List<String> msToTimeStringsGerman(long milliseconds) {
        int seconds = (int) Math.floor(milliseconds / 1000);
        int minutes = (int) Math.floor(seconds / 60);
        int hours = (int) Math.floor(minutes / 60);
        int days = (int) Math.floor(hours / 24);
        int months = (int) Math.floor(days / 30);
        int years = (int) Math.floor(days / 365);

        seconds %= 60;
        minutes %= 60;
        hours %= 24;
        days %= 30;
        months %= 12;

        List<String> result = new ArrayList<>();
        if (years > 0) {
            result.add(timePad(years) + " Jahr(e)");
            result.add(timePad(months) + " Monat(e)");
            result.add(timePad(days) + " Tag(e)");
        } else if (months > 0) {
            result.add(timePad(months) + " Monat(e)");
            result.add(timePad(days) + " Tag(e)");
            result.add(timePad(hours) + " Stunde(n)");
        } else if (days > 0) {
            result.add(timePad(days) + " Tag(e)");
            result.add(timePad(hours) + " Stunde(n)");
            result.add(timePad(minutes) + " Minute(n)");
        } else if (hours > 0) {
            result.add(timePad(hours) + " Stunde(n)");
            result.add(timePad(minutes) + " Minute(n)");
            result.add(timePad(seconds) + " Sekunde(n)");
        } else if (minutes > 0) {
            result.add(timePad(minutes) + " Minute(n)");
            result.add(timePad(seconds) + " Sekunde(n)");
        } else {
            result.add(timePad(seconds) + " Sekunde(n)");
        }
        return result;
    }

    public static long parseTime(String time) {
        return TimeParser.parse(time).toMillis();
    }

    public static Duration parseTimeToDuration(String time) {
        return TimeParser.parse(time);
    }

    public static class TimeParser {

        public static Duration parse(String time) {
            int years = 0, months = 0, days = 0, hours = 0, minutes = 0, seconds = 0, milliseconds = 0;

            String[] parts = time.split(" ");
            for (String part : parts) {
                int value = Integer.parseInt(part.substring(0, part.length() - 1));
                char unit = part.charAt(part.length() - 1);
                switch (unit) {
                    case 'h':
                        hours = value;
                        break;
                    case 'm':
                        if (part.endsWith("m")) {
                            minutes = value;
                        } else if (part.endsWith("ms")) {
                            milliseconds = value;
                        } else {
                            months = value;
                        }
                        break;
                    case 's':
                        seconds = value;
                        break;
                    case 'd':
                        days = value;
                        break;
                    case 'y':
                        years = value;
                        break;
                }
            }

            Duration duration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds).plusMillis(milliseconds).plus(Duration.of(years, ChronoUnit.YEARS)).plus(Duration.of(months, ChronoUnit.MONTHS));

            return duration;
        }
    }

}
