public class Main {
    public static void main(String[] args) {
        /*if (args.length > 0) {
            System.out.println(args[0]);
        }*/
        ConfigurationParser configParser = new ConfigurationParser();
        if(args.length>0){
            configParser.parseFile(args[0]);
        }else{
            configParser.parseFile("");
        }
        //System.out.println(configParser.getConfigMap());

        System.out.println(configParser.get("application.name"));
    }
}
