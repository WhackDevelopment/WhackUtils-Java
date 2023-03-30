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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * WhackUtils; com.whackdevelopment.utils.time:DateUtils
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    public static String formatDate(Date now, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(now);
    }

    public static String formatDate(LocalDate now, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(now);
    }

    public static String convertDateToHHMMSS(Date now) {
        return formatDate(now, "HH:mm:ss");
    }

    public static String convertDateToHHMMSS(LocalDate now) {
        return formatDate(now, "HH:mm:ss");
    }

    public static String convertDateToString(Date now) {
        return formatDate(now, "dd/MM/yyyy HH:mm:ss");
    }

    public static String convertDateToString(LocalDate now) {
        return formatDate(now, "dd/MM/yyyy HH:mm:ss");
    }

}
