package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final Path pathPlainExpected = Path.of("src/test/resources/expected/plainTest.txt")
            .toAbsolutePath().normalize();
    private final Path pathStylishExpected = Path.of("src/test/resources/expected/stylishTest.txt")
            .toAbsolutePath().normalize();
    private final Path pathJsonExpected = Path.of("src/test/resources/expected/jsonTest.txt");
    private final String pathJson1 = "src/test/resources/file1.json";
    private final String pathJson2 = "src/test/resources/file2.json";

    @Test
    void generatePlainTest() throws Exception {
        String expectedResult = Files.readString(pathPlainExpected);
        String pathYaml1 = "src/test/resources/file1.yaml";
        String pathYaml2 = "src/test/resources/file2.yaml";
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2, "plain"));
    }

    @Test
    void generateStylishTest() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "stylish"));
    }

    @Test
    void generateStylishDefaultTest() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2));
    }

    @Test
    void generateJsonTest() throws Exception {
        String expectedResult = Files.readString(pathJsonExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "json"));
    }
}
