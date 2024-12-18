package core.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

  public static List<Object[]> loadCsv(String filePath) {
    List<Object[]> data = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        data.add(values);
      }
    } catch (IOException e) {
      throw new RuntimeException("Error reading CSV file: " + filePath, e);
    }
    return data;
  }
}
