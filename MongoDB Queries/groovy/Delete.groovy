import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;

try {
	// Retrieve MongoDB collection from JMeter variables
    	MongoCollection<Document> collection = vars.getObject("collection");

	// Define filter to delete documents with selected attributes
    	collection.deleteMany(eq("Sector", "Weapons Manufacturing"));

    	return"Documents deleted";
    }
    
    catch(Exception e) {
    	SampleResult.setSuccessful(false);
    	SampleResult.setResponseCode("500");
    	SampleResult.setResponseMessage("Exception: " + e);
    }
