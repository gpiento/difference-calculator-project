package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static Path pathPlainExpected;
    private static Path pathStylishExpected;
    private static Path pathJsonExpected;
    private static String pathJson1;
    private static String pathJson2;
    private static String pathYaml1;
    private static String pathYaml2;

    @BeforeAll
    public static void setUp() throws IOException {
        pathPlainExpected = Path.of("src/test/resources/expected/plainTest.txt")
                .toAbsolutePath().normalize();
        pathStylishExpected = Path.of("src/test/resources/expected/stylishTest.txt")
                .toAbsolutePath().normalize();
        pathJsonExpected = Path.of("src/test/resources/expected/jsonTest.txt")
                .toAbsolutePath().normalize();
        pathJson1 = "src/test/resources/fixtures/file1.json";
        pathJson2 = "src/test/resources/fixtures/file2.json";
        pathYaml1 = "src/test/resources/fixtures/file1.yaml";
        pathYaml2 = "src/test/resources/fixtures/file2.yaml";
    }

    @Test
    void generatePlainFromYaml() throws Exception {
        String expectedResult = Files.readString(pathPlainExpected);
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2, "plain"));
    }

    @Test
    void generatePlainFromJson() throws Exception {
        String expectedResult = Files.readString(pathPlainExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "plain"));
    }

    @Test
    void generateStylishFromYaml() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2, "stylish"));
    }

    @Test
    void generateStylishFromJson() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "stylish"));
    }

    @Test
    void generateJsonFromYaml() throws Exception {
        String expectedResult = Files.readString(pathJsonExpected);
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2, "json"));
    }

    @Test
    void generateJsonFromJson() throws Exception {
        String expectedResult = Files.readString(pathJsonExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "json"));
    }

    @Test
    void generateStylishFromYamlWithDeffer() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2));
    }

    @Test
    void generateStylishFromJsonWithDeffer() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2));
    }
}
