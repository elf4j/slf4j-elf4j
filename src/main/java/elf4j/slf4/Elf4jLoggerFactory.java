package elf4j.slf4;

import elf4j.impl.NativeLoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elf4jLoggerFactory implements ILoggerFactory {
    private static final Class<LoggerFactory> ELF4J_ACCESS_INTERFACE = LoggerFactory.class;
    private static final Class<Elf4jLogger> ELF4J_SERVICE_INTERFACE = Elf4jLogger.class;
    private final NativeLoggerFactory nativeLoggerFactory =
            new NativeLoggerFactory(ELF4J_ACCESS_INTERFACE, ELF4J_SERVICE_INTERFACE);

    @Override
    public Logger getLogger(String name) {
        return new Elf4jLogger(nativeLoggerFactory.logger());
    }
}
