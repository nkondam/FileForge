package org.fileforge;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        subcommands = {
                Create.class,
                Delete.class,
                Copy.class,
                Move.class
        },
        name = "ff",
        description = "Java Command-Line file manager",
        mixinStandardHelpOptions = true,
        version = "FileForge 1.0"
)
public class FileForge implements Runnable {

        public static void main(String[] args) {
                CommandLine commandLine = new CommandLine(new FileForge());
                commandLine.execute(args);
        }

        @Override
        public void run() {
                System.out.println("Best File Manager!");
        }
}
