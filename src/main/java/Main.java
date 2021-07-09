public class Main {
    public static void main(String[] args) {
        if(args.length > 0) {
            System.out.println(args[0]);
        }
        ConfigurationParser configParser = new ConfigurationParser();
        configParser.parseFile(args[0]);
        System.out.println(configParser.get("name"));
    }
}
