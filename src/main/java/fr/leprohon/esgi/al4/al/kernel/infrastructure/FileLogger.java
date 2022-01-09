package fr.leprohon.esgi.al4.al.kernel.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.service.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class FileLogger implements Log {
    private final Path path;

    public FileLogger(Path path) {
        this.path = path;
    }

    @Override
    public void log(String message) {
        Date date = new Date();
        try(FileWriter fileWriter = new FileWriter(path.toFile(), true)) {
            fileWriter.append(date + ": " + message);
            fileWriter.append("\n");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
