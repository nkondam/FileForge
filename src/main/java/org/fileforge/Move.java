package org.fileforge;

import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@CommandLine.Command(
        name = "mv",
        description = "moves file from one location to another"
)
public class Move implements Runnable{
    @CommandLine.Option(
            names = {"-m", "--move"},
            description = "move the file"
    )
    private String origin;

    @CommandLine.Option(
            names = {"-t", "--to"},
            description = "to destination"
    )
    private String dest;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Copy()).execute(args);
        System.exit(exitCode);

    }
    @Override
    public void run() {
        if (origin != null && dest != null) {
            try {
                Files.move(Path.of(origin), Path.of(dest));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
