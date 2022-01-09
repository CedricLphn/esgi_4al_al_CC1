package fr.leprohon.esgi.al4.al.kernel.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.service.Log;

import java.util.ArrayList;

public class Loggers implements Log {

    private final ArrayList<Log> loggersList;

    public Loggers(ArrayList<Log> loggersList) {
        this.loggersList = loggersList;
    }

    @Override
    public void log(String message) {
        loggersList.forEach(logger -> logger.log(message));
    }
}
