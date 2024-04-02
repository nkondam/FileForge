package org.fileforge;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(
        name = "cp",
        description = "copy the file and paste it at given path"
)
public class Copy implements Runnable{

    @Option(
            names = {"-c", "--copy"},
            description = "Copies the file"
    )
    private String copyPath;

    @Option(
            names = {"-p", "--paste"},
            description = "Pastes copied file"
    )
    private String pastePath;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Copy()).execute(args);
        System.exit(exitCode);

    }
    @Override
    public void run() {
        if (copyPath != null && pastePath != null) {
            try {
                Files.copy(Path.of(copyPath), Path.of(pastePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
