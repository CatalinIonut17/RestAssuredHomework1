package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReader {
    private static Properties properties = new Properties();

    static{
        InputStream inputStream = EnvReader.class.getClassLoader().getResourceAsStream("env.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUri(){
        return properties.getProperty("baseUri");
    }

    public static String getBasePath(){
        return properties.getProperty("basePath");
    }

    public static Integer getPort(){
        return Integer.parseInt(properties.getProperty("port"));
    }
}
