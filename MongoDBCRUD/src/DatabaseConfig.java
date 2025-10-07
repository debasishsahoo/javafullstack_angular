import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseConfig {
	private static final String CONNECTION_STRING = "mongodb://localhost:27017";
	private static final String DATABASE_NAME = "school_db";
	private static final String COLLECTION_NAME = "students";

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	public static void connect() {
		try {
			System.out.println(" Connecting to MongoDB...");
			mongoClient = MongoClients.create(CONNECTION_STRING);
			database = mongoClient.getDatabase(DATABASE_NAME);
			collection = database.getCollection(COLLECTION_NAME);

			// Test connection
			database.listCollectionNames().first();

			System.out.println(" Connected to MongoDB successfully!");
			System.out.println(" Database: " + DATABASE_NAME);
			System.out.println(" Collection: " + COLLECTION_NAME + "\n");
		} catch (Exception e) {
			System.out.println(" Failed to connect to MongoDB!");
			System.out.println(" Make sure MongoDB is running on localhost:27017");
			throw new RuntimeException("Connection failed", e);
		}
	}

	public static MongoCollection<Document> getCollection() {
		return collection;
	}

	public static MongoDatabase getDatabase() {
		return database;
	}

	public static void close() {
		if (mongoClient != null) {
			mongoClient.close();
			System.out.println("\n MongoDB connection closed.");
		}
	}

}
