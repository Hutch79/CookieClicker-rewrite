package ch.hutch79.cookieclicker.util;

public class ConfigManager {

    public void saveConfig(String path, String yamlPath){
        saveConfig(path, yamlPath, false);
    }

    public void saveConfig(String path, String yamlPath, Boolean loadDefaultOnCreate){

        // Do some magic and save stuff to a config if it already exists.
        // If not, create it and save the date after. Also, you may create it with a default config template.

    }

    public String readConfig(String path, String yamlPath){

        // Do some magic and give me the stuff i want to know

        return "Lol, am I really a String?";

    }

}
