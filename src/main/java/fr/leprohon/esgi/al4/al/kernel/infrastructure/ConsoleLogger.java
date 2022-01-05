package fr.leprohon.esgi.al4.al.kernel.infrastructure;
import fr.leprohon.esgi.al4.al.kernel.service.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConsoleLogger implements Log {

    private static final Logger LOGGER = Logger.getLogger(Class.class.getSimpleName());

    @Override
    public void log(String message) {
        if(LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, message);
        }
    }
}
