package net.volodin.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    private static Properties prop;

    /**
     * This method will read the properties file
     *
     * @param filePath Full path to the config file
     */
    private static void readProperties(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**
     * Method returns the value for a specific key
     *
     * @param key Property key
     * @return Property of input value
     */
    public static String getProperty(String key) {
        readProperties(Constants.CONFIGURATION_FILEPATH);
        return prop.getProperty(key);
    }
}
