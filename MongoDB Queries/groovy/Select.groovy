import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.types.ObjectId;

try {
	//Retrieve MongoDB collection from JMeter variables
    	MongoCollection<Document> collection = vars.getObject("collection");

	//Query for document with specified attribute
    	List<Document> result = collection.find(eq("Sector", "Computer Hardware")).into(new ArrayList<>());

    	return "Documents in the Computer Hardware sector found" 
    }
    catch(Exception e) {
    	SampleResult.setSuccessful(false);
    	SampleResult.setResponseCode("500");
    	SampleResult.setResponseMessage("Exception: "+ e);
    }
