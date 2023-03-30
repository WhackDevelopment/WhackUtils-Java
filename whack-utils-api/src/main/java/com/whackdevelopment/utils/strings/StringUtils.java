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

package com.whackdevelopment.utils.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * WhackUtils; com.whackdevelopment.utils.strings:StringUtils
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static boolean startsWithIgnoreCase(String string, String prefix) {
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static void copyPartialMatches(String input, Collection<String> available, Collection<String> toAppend) {
        for (String string : available) {
            if (startsWithIgnoreCase(string, input)) {
                toAppend.add(string);
            }
        }
    }

    public static void copySortPartialMatches(String input, Collection<String> available, List<String> toAppend) {
        for (String string : available) {
            if (startsWithIgnoreCase(string, input)) {
                toAppend.add(string);
            }
        }
        Collections.sort(toAppend);
    }

    public static void copySortReversePartialMatches(String input, Collection<String> available, List<String> toAppend) {
        for (String string : available) {
            if (startsWithIgnoreCase(string, input)) {
                toAppend.add(string);
            }
        }
        Collections.sort(toAppend, Collections.reverseOrder());
    }

}
