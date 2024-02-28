package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    Path pathPlainExpected = Path.of("src/test/resources/expected/plainTest.txt");
    Path pathStylishExpected = Path.of("src/test/resources/expected/stylishTest.txt");
    Path pathJsonExpected = Path.of("src/test/resources/expected/jsonTest.txt");
    String pathJson1 = "src/test/resources/file1.json";
    String pathJson2 = "src/test/resources/file2.json";
    String pathYaml1 = "src/test/resources/file1.yaml";
    String pathYaml2 = "src/test/resources/file2.yaml";

    @BeforeAll
    public static void beforeAll() {

    }

    @Test
    void generatePlainTest() throws Exception {
        String expectedResult = Files.readString(pathPlainExpected);
        assertEquals(expectedResult, Differ.generate(pathYaml1, pathYaml2, "plain"));
    }

    @Test
    void generateStylishTest() throws Exception {
        String expectedResult = Files.readString(pathStylishExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "stylish"));
    }

    @Test
    void generateJsonTest() throws Exception {
        String expectedResult = Files.readString(pathJsonExpected);
        assertEquals(expectedResult, Differ.generate(pathJson1, pathJson2, "json"));
    }

    @Test
    void generateTest() throws Exception {

        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expectedResult = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }
                """;

        String result = Differ.generate(filePath1, filePath2, "stylish");

        //assertEquals(expectedResult, result);
    }
}
