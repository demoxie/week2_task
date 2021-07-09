import java.util.HashMap;
import java.util.Map;

public class ConfigurationParser {
    Map<String, String> configMap = new HashMap();
    public String get(String configKey) {
        return "config value";
    }

    public void parseFile(String variable) {
        if (variable == "development") {
            // get sonfig.txt.dev
            // extract all the values in the file
            // parse the file and save the key value pairs in configMap
        } else if (variable == "staging") {

        }

        System.out.println(variable);

    }
}
