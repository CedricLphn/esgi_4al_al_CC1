package common.infrastructure;
import common.service.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConsoleLogger implements Log {

    private static final Logger LOGGER = Logger.getLogger(ConsoleLogger.class.getName());

    @Override
    public void log(String message) {
        if(LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, message);
        }
    }
}
