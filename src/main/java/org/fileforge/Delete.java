package org.fileforge;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(
        name = "del",
        description = "Deletes given file name"
)
public class Delete implements Runnable {

    @Option(
            names = {"-d", "--delete"},
            description = "deletes given filename"
    )
    private String filename;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Delete()).execute(args);
        System.exit(exitCode);

    }
    @Override
    public void run() {
        if (filename != null) {
            try {
                Files.deleteIfExists(Path.of(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
