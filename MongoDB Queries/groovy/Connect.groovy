import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

try {
    // Specify the maximum connection pool size 
    int maxConnections = 20;

    // Specify the maximum wait time in milliseconds
    int maxWaitTimeMS = 1000;

    // Build MongoDB connection string with maxIdleTimeMS optionS
    String connectionString = String.format("mongodb://%s:%s/?maxIdleTimeMS=%d&socketTimeoutMS=100000000",
            vars.get("mongoHost"), vars.get("mongoPort"), maxWaitTimeMS);

    // Parse the connection string
    ConnectionString connString = new ConnectionString(connectionString);

    // Build MongoDB client settings using the parsed connection string
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .applyToClusterSettings(builder ->
                    builder.hosts(Arrays.asList(new ServerAddress(vars.get("mongoHost"), vars.get("mongoPort").toInteger()))))
            .build();

    // Create MongoDB client with specified settings
    MongoClient mongoClient = MongoClients.create(settings);

    // Access desired MongoDB database defined by JMeter variable
    MongoDatabase database = mongoClient.getDatabase(vars.get("databaseName"));

    // Access desired MongoDB collection defined by JMeter variable
    MongoCollection<Document> collection = database.getCollection(vars.get("collectionName"));

    // Store MongoDB collection in JMeter variable
    vars.putObject("collection", collection);

    return "Connected to " + vars.get("collectionName");
} catch (Exception e) {
    SampleResult.setSuccessful(false);
    SampleResult.setResponseCode("500");
    SampleResult.setResponseMessage("Exception: " + e);
}
