package elf4j.slf4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class IntegrationTest {
    Logger logger = LoggerFactory.getLogger(IntegrationTest.class);

    @Test
    void it() {
        logger.info("Hello, {}!", "world");
        String houstonMessage = "Houston, we don't have a problem";
        logger.warn("And... " + houstonMessage, new Exception(houstonMessage));
        logger.atDebug()
                .setCause(new Exception("test fluent api ex message"))
                .setMessage("testing slf4j {} api")
                .addArgument("fluent")
                .log();
    }
}