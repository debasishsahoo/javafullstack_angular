package Q09;

import java.util.HashMap;
import java.util.Map;

public class CacheManagerDemo {

	private static Map<String, CachedData> cache = new HashMap<>();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Cache Manager with Background Cleanup Daemon ===");

		// Add some sample cache entries
		addCacheEntry("A", 5000); // expires in 5 seconds
		addCacheEntry("B", 10000); // expires in 10 seconds

		// Start background cleanup daemon
		startCleanupDaemon();

		// Simulate main application running
		for (int i = 1; i <= 12; i++) {
			System.out.println("Main application running... " + i + "s");
			Thread.sleep(1000);
		}

		System.out.println("Main application ending. Daemon cleanup thread will stop automatically.");
	}

	private static void addCacheEntry(String key, long ttlMillis) {
		cache.put(key, new CachedData(System.currentTimeMillis() + ttlMillis));
		System.out.println("Added cache entry: " + key);
	}

	public static void startCleanupDaemon() {
		Thread cleanup = new Thread(() -> {
			while (true) {
				removeExpiredEntries();
				try {
					Thread.sleep(2000); // check every 2 seconds for demo purposes
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		cleanup.setDaemon(true);
		cleanup.setName("CacheCleanupDaemon");
		cleanup.start();
	}

	private static void removeExpiredEntries() {
		long now = System.currentTimeMillis();
		int before = cache.size();
		cache.entrySet().removeIf(entry -> entry.getValue().isExpired(now));
		int after = cache.size();
		if (before != after) {
			System.out.println("Cleaned expired cache entries. Remaining: " + after);
		}
	}

	static class CachedData {
		long expiryTime;

		CachedData(long expiryTime) {
			this.expiryTime = expiryTime;
		}

		boolean isExpired(long now) {
			return now > expiryTime;
		}
	}
}
