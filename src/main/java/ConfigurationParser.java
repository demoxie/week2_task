import Exceptions.UnidentifiedKeyException;

import java.io.*;

import java.util.*;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConfigurationParser {
    private final String pathName;

    public Map<String, List<String>> getConfigMap() {
        return configMap;
    }

    private Map<String, List<String>>  configMap;

    public ConfigurationParser() {
        this.pathName = "/Users/t/Documents/GitHub/week2_task_demo/src/main/java/files/";
        this.configMap = new HashMap<>();
    }
    public int getConfigMapSize(){
        return configMap.size();
    }

    public String getPathName() {
        return pathName;
    }

    public String get(String configKey) {
        String value = "";
        if(configKey.equals("")){
            throw new UnidentifiedKeyException();
        }else if(configKey.equals("name")){
            value = this.configMap.get(configKey).get(1);
        }else {
            value = this.configMap.get("name").get(0);
        }
        return value;

    }

    public void parseFile(String variable) {
        if (variable.equals("development")) {
            // get config.txt.dev
            // extract all the values in the file
            // parse the file and save the key value pairs in configMap
            this.configMap = copyFileContentIntoMap("config.txt.dev");
        } else if (variable.equals("staging")) {
            this.configMap = copyFileContentIntoMap("config.txt.staging");
        } else {
            this.configMap = copyFileContentIntoMap("config.txt");
        }

    }


    public Map<String, List<String>>  copyFileContentIntoMap(String fileName) {

        Map<String, List<String>> mapFileContents = new HashMap<>();
        BufferedReader br = null;

        try {

            //create file object
            String dir = this.pathName + fileName;
            File file = new File(dir);

            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line;

            //read file line by line
            while ((line = br.readLine()) != null) {

                if (line.contains("=")) {
                    //split the line by :
                    String[] parts = line.split("=");

                    //first part is key, second is value
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    //put key, value in HashMap if they are not empty
                    List<String> list = new ArrayList<>();
                    if (!key.equals("") && !value.equals("")) {
                        if (this.configMap.containsKey(key)) {
                            list = configMap.get(key);
                            list.add(value);
                            this.configMap.put(key, list);
                            mapFileContents.put(key, list);
                        } else {
                            list.add(value);
                            this.configMap.put(key, list);
                            mapFileContents.put(key, list);
                        }
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                ;
            }
        }

        return mapFileContents;

    }


}
