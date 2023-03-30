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

package com.whackdevelopment.utils.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

/**
 * WhackUtils; com.whackdevelopment.utils.data:DataLoader
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataLoader {

    private static Gson gson = new GsonBuilder().create();

    /**
     * Loads a provided config object from a given JSON file.
     * If the file does not exist it also creates the file using the given object defaults
     *
     * @param clazz The object type you wish to load, also dictates the class of the returned object
     * @param file  The file that is to be created/read from
     * @return The object loaded from file
     * @throws IOException
     * @since 30.03.2023
     */
    public static <T> T loadData(Class<T> clazz, File file) throws IOException {
        if (file.createNewFile()) { //File does not exist, save to file
            String json = gson.toJson(JsonParser.parseString(gson.toJson(clazz)));
            try (PrintWriter out = new PrintWriter(file)) {
                out.println(json);
            }
        } else { //File exists, load from file
            return gson.fromJson(new String(Files.readAllBytes(file.toPath())), clazz);
        }

        return null;
    }

    /**
     * Saves a config object to the specified file in JSON format
     *
     * @param data The object to be saved
     * @param file The file to which the object is saved
     * @throws IOException
     * @since 30.03.2023
     */
    public static void saveData(Object data, File file) throws IOException {
        file.createNewFile();
        String json = gson.toJson(JsonParser.parseString(gson.toJson(data)));
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(json);
        }
    }

}
