package fr.leprohon.esgi.al4.al.kernel.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.service.Log;

public class NullLogger implements Log {
    @Override
    public void log(String message) {
        // Nothing
    }
}
