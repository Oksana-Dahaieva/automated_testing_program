package core.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

  private Map<String, Object> contextMap = new HashMap<>();

  public void setContext(String key, Object value) {
    contextMap.put(key, value);
  }

  public Object getContext(String key) {
    return contextMap.get(key);
  }

  public boolean isContextPresent(String key) {
    return contextMap.containsKey(key);
  }

}
