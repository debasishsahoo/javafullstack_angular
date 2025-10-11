package Mistakes.Mistake3;

import java.util.HashMap;
import java.util.Map;

public class GoodCache {
private Map<String, Object> cache = new HashMap<>();
    
    public Object get(String key) {
        return cache.get(key);
    }
    
    public void put(String key, Object value) {
        cache.put(key, value);
    }
    
    // Implementation can change from HashMap to something else
}
