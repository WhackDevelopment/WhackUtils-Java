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

package com.whackdevelopment.utils.resources;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * WhackUtils; com.whackdevelopment.utils.resources:ResourceUtils
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 30.03.2023
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourceUtils {

    /**
     * read a resource file to {@link String}
     *
     * @param resourcePath path to the resource in your JAR
     * @return the content of the resource file or null when file cannot be read
     * @since 30.03.2023
     */
    public static @Nullable String readResource(@NotNull String resourcePath) {
        if (!resourcePath.startsWith("/")) resourcePath = "/" + resourcePath;
        try {
            byte bytes[] = ResourceUtils.class.getClassLoader().getResourceAsStream(resourcePath).readAllBytes();
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * save a resource file
     *
     * @param toFolder          folder in which the resource should be saved ( keeps JAR paths )
     * @param resourcePath      path to the resource in your JAR
     * @param overwriteExisting true if existing file should be overwritten
     * @return if the content og the resource file was saved
     * @throws IOException when error while saving resource
     * @since 30.03.2023
     */
    public static boolean saveResource(@NotNull File toFolder, @NotNull String resourcePath, boolean overwriteExisting) throws IOException {
        if (!resourcePath.startsWith("/")) resourcePath = "/" + resourcePath;
        File file = new File(toFolder, resourcePath);
        if (!file.exists() || overwriteExisting) {
            InputStream in = ResourceUtils.class.getResourceAsStream(resourcePath);
            if (in == null) return false;
            Files.copy(in, file.toPath());
            return true;
        } else return false;
    }

}
