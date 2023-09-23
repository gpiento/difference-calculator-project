package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {

    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest, "app should have a greeting");
    }
}
