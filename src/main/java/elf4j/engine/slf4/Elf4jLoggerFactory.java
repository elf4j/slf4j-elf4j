/*
 * MIT License
 *
 * Copyright (c) 2023 Qingtian Wang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package elf4j.engine.slf4;

import elf4j.engine.NativeLogServiceProvider;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** */
public class Elf4jLoggerFactory implements ILoggerFactory {
    private static final Class<LoggerFactory> LOGGING_SERVICE_ACCESS_CLASS = LoggerFactory.class;
    private final NativeLogServiceProvider nativeLogServiceProvider;
    private final Map<String, Elf4jLogger> elf4jLoggerMap = new HashMap<>();

    Elf4jLoggerFactory() {
        nativeLogServiceProvider = new NativeLogServiceProvider(LOGGING_SERVICE_ACCESS_CLASS);
    }

    @Override
    public Logger getLogger(String name) {
        return elf4jLoggerMap.computeIfAbsent(name, k -> new Elf4jLogger(nativeLogServiceProvider.logger()));
    }
}
