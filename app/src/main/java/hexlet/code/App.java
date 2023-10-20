package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Option;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    static String filePath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    static String filePath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    String fileFormat;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this @|fg(cyan) help|@ message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {

        String diff = Differ.generate(filePath1, filePath2, fileFormat);
        return 0;
    }
}
