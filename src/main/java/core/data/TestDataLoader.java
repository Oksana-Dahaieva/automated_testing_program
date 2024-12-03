package core.data;

import java.io.IOException;

public class TestDataLoader {

  public static String getConfigValue(String key) {
    try (var input = TestDataLoader.class
        .getClassLoader()
        .getResourceAsStream("properties/reportportal.properties")) {
      var properties = new java.util.Properties();
      properties.load(input);
      return properties.getProperty(key);
    } catch (IOException e) {
      throw new RuntimeException("Unable to load config.properties", e);
    }
  }
}
