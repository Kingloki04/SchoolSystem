package tech.lpdev.managers;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;

@Getter
public class DatabaseManager {

    private MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    /**
     * Creates a connection to the database
     *
     * @param mongoURI The uri of the requested database
     * @param db       The name of the requested database
     */
    public void setupMongo(String mongoURI, String db) {

        try {
            mongoClient = MongoClients.create(mongoURI);
            mongoDatabase = mongoClient.getDatabase(db);

        } catch (Exception exception) {
            System.out.println("[!] There was an error while trying to connect to MongoDB!");
        }
    }

    /**
     *
     * @param name The name of the requested collection
     * @return     The requested document of the requested collection
     */
    public static MongoCollection<Document> getCollection(String name) {
        return mongoDatabase.getCollection(name);
    }
}
