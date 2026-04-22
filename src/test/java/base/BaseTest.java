package base;

import utils.BrowserFactory;
import java.util.Properties;
import java.io.InputStream;

public class BaseTest {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream("config.properties")) { // Load the config.properties file from the classpath
            if (input != null) {   // Check if the input stream is not null before loading the properties
                properties.load(input); // Load the properties from the input stream
            } else {                    // If the input stream is null, it means the config.properties file was not found in the classpath
                throw new RuntimeException("config.properties not found in classpath"); // Throw a runtime exception with a message indicating that the config.properties file was not found
            }
        } catch (Exception e) {   // Catch any exceptions that occur during the loading of the properties and throw a runtime exception with a message indicating that there was an error loading the config.properties file
            throw new RuntimeException("Error loading config.properties", e);  // Throw a runtime exception with a message indicating that there was an error loading the config.properties file and include the original exception as the cause
        }
    }

    public static final String URL = properties.getProperty("url");   // Get the URL property from the loaded properties and assign it to a constant variable
    public static final String browserName = properties.getProperty("browser");  // Get the browser property from the loaded properties and assign it to a constant variable



}
