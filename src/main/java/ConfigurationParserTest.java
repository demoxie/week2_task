import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationParserTest {
    ConfigurationParser configParser;
    @BeforeEach
    void setUp() {
        configParser = new ConfigurationParser();
        configParser.parseFile("development");
    }

    @Test
    void getConfigMapSize() {

        System.out.println(configParser.get("application.name"));
        assertEquals(8,configParser.getConfigMap().size());
    }

    @Test
    void get() {
        assertEquals("fintrack-development",configParser.get("name"));
    }
}