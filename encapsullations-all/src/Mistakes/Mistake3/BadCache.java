package Mistakes.Mistake3;

import java.util.HashMap;
//BAD - Exposes implementation detail
//Mistake 3: Exposing Internal Implementation
public class BadCache {
private HashMap<String, Object> cache = new HashMap<>();
    
    public HashMap<String, Object> getCache() {
        return cache;
    }
}
