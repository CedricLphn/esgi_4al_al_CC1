package common.infrastructure;

import common.service.Log;

public class NullLogger implements Log {
    @Override
    public void log(String message) {
        // Nothing
    }
}
