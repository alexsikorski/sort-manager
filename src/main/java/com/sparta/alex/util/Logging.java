package com.sparta.alex.util;

import com.sparta.alex.start.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void runExceptions() {
        int number = 20;
        int divisor = 0;

        try {
            int quotient = number / divisor;
        } catch (ArithmeticException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
