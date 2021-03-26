package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            // what file to read
            //configuration.class src un altında değil ve src ile aynı hizada aynı profenin altında
            // o yüzden relative path yolu dosya ismi oluyor
            String path = "configuration.properties";
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties(); // yukardadeclare edilen classtan obje oluşturduk
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

        //get method return key value us
        public static String get(String keyName) {

          return properties.getProperty(keyName);
    }
}
