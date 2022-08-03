package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TwitterReader {
    private static Properties properties = new Properties();

    static{
        InputStream inputStream = EnvReader.class.getClassLoader().getResourceAsStream("twitter.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUri(){
        return properties.getProperty("baseUriTwitter");
    }
    public static String getBasePath(){
        return properties.getProperty("basePathTwitter");
    }

    public static String getApiKey(){
        return properties.getProperty("ApiKey");
    }

    public static String getApiKeySecret(){
        return properties.getProperty("ApiKeysecret");
    }

    public static String getAccessToken(){
        return properties.getProperty("AccessToken");
    }

    public static String getAccessTokenSecret(){
        return properties.getProperty("AccessTokenSecret");
    }
}
