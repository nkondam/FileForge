package org.fileforge;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.createFile;

@Command(
        name = "cr",
        description = "Creates File with given name",
        mixinStandardHelpOptions = true,
        version = "File Forge 1.0"
)
public class Create implements Runnable {
    @Option(names = {"-f", "--filename"}, description = "Creates a new file with given name")
    private String filename;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Create()).execute(args);
        System.exit(exitCode);
    }


    public void run() {
        if (filename != null) {
            Path file = Path.of(filename);
            if (!file.toFile().exists()) {
                try {
                    createFile(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
