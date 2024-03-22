package com.f2x.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilProperties {
    public static String getData(String propertie){
        String myPropertie = propertie;
        Properties properties= new java.util.Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("serenity.properties");
            properties.load(input);

            return properties.getProperty(myPropertie);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
