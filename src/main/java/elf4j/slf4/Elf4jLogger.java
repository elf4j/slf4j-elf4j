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

package elf4j.slf4;

import elf4j.Level;
import elf4j.impl.NativeLogger;
import elf4j.impl.util.StackTraceUtils;
import elf4j.impl.util.ThreadLocalContext;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.LoggingEvent;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.slf4j.spi.LoggingEventAware;

import java.util.EnumMap;

public class Elf4jLogger implements Logger, LoggingEventAware {
    private static final EnumMap<org.slf4j.event.Level, Level> SLF4J_EVENT_TO_ELF4J_LEVEL_MAP =
            new EnumMap<>(org.slf4j.event.Level.class);
    private static final Class<DefaultLoggingEventBuilder> SLF4J_FLUENT_LOGGING_SERVICE_INTERFACE =
            DefaultLoggingEventBuilder.class;

    static {
        SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.put(org.slf4j.event.Level.TRACE, Level.TRACE);
        SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.put(org.slf4j.event.Level.DEBUG, Level.DEBUG);
        SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.put(org.slf4j.event.Level.INFO, Level.INFO);
        SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.put(org.slf4j.event.Level.WARN, Level.WARN);
        SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.put(org.slf4j.event.Level.ERROR, Level.ERROR);
    }

    private final NativeLogger nativeLogger;

    public Elf4jLogger(NativeLogger nativeLogger) {
        this.nativeLogger = nativeLogger;
    }

    private static Level translate(org.slf4j.event.Level slf4jEventLevel) {
        return SLF4J_EVENT_TO_ELF4J_LEVEL_MAP.get(slf4jEventLevel);
    }

    @Override
    public String getName() {
        return nativeLogger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return isEnabled(Level.TRACE);
    }

    @Override
    public void trace(String msg) {
        elf4jLog(Level.TRACE, null, msg);
    }

    @Override
    public void trace(String format, Object arg) {
        elf4jLog(Level.TRACE, null, format, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        elf4jLog(Level.TRACE, null, format, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        elf4jLog(Level.TRACE, null, format, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        elf4jLog(Level.TRACE, t, msg);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return this.isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String msg) {
        this.trace(msg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        this.trace(format, arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        this.trace(format, arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        this.trace(format, argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        this.trace(msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return isEnabled(Level.DEBUG);
    }

    @Override
    public void debug(String msg) {
        elf4jLog(Level.DEBUG, null, msg);
    }

    @Override
    public void debug(String format, Object arg) {
        elf4jLog(Level.DEBUG, null, format, arg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        elf4jLog(Level.DEBUG, null, format, arg1, arg2);
    }

    @Override
    public void debug(String format, Object... arguments) {
        elf4jLog(Level.DEBUG, null, format, arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        elf4jLog(Level.DEBUG, t, msg);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return this.isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String msg) {
        this.debug(msg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        this.debug(format, arg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        this.debug(format, arg1, arg2);
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        this.debug(format, arguments);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        this.debug(msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return isEnabled(Level.INFO);
    }

    @Override
    public void info(String msg) {
        elf4jLog(Level.INFO, null, msg);
    }

    @Override
    public void info(String format, Object arg) {
        elf4jLog(Level.INFO, null, format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        elf4jLog(Level.INFO, null, format, arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        elf4jLog(Level.INFO, null, format, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        elf4jLog(Level.INFO, t, msg);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return this.isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String msg) {
        this.info(msg);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        this.info(format, arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        this.info(format, arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        this.info(format, arguments);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        this.info(msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return isEnabled(Level.WARN);
    }

    @Override
    public void warn(String msg) {
        elf4jLog(Level.WARN, null, msg);
    }

    @Override
    public void warn(String format, Object arg) {
        elf4jLog(Level.WARN, null, format, arg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        elf4jLog(Level.WARN, null, format, arguments);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        elf4jLog(Level.WARN, null, format, arg1, arg2);
    }

    @Override
    public void warn(String msg, Throwable t) {
        elf4jLog(Level.WARN, t, msg);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return this.isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String msg) {
        this.warn(msg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        this.warn(format, arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        this.warn(format, arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        this.warn(format, arguments);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        this.warn(msg, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return isEnabled(Level.ERROR);
    }

    @Override
    public void error(String msg) {
        elf4jLog(Level.ERROR, null, msg);
    }

    @Override
    public void error(String format, Object arg) {
        elf4jLog(Level.ERROR, null, format, arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        elf4jLog(Level.ERROR, null, format, arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        elf4jLog(Level.ERROR, null, format, arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        elf4jLog(Level.ERROR, t, msg);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return this.isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String msg) {
        this.error(msg);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        this.error(format, arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        this.error(format, arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        this.error(format, arguments);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        this.error(msg, t);
    }

    @Override
    public void log(LoggingEvent event) {
        if (nativeLogger.getLogService().includeCallerDetail()) {
            ThreadLocalContext.data().setCallerFrame(StackTraceUtils.callerOf(SLF4J_FLUENT_LOGGING_SERVICE_INTERFACE));
        }
        elf4jLog(translate(event.getLevel()), event.getThrowable(), event.getMessage(), event.getArgumentArray());
    }

    private void elf4jLog(Level level, Throwable t, String msg, Object... args) {
        nativeLogger.atLevel(level).log(t, msg, args);
    }

    private boolean isEnabled(Level elf4jLevel) {
        return nativeLogger.atLevel(elf4jLevel).isEnabled();
    }
}
