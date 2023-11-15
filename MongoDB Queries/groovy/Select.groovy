import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.types.ObjectId;

try {
	//Retrieve MongoDB collection from JMeter variables
    	MongoCollection<Document> collection = vars.getObject("collection");

	//Query for document with specified attribute
    	Document result = collection.find(eq("Sector", "Communication Equipments")).first();

	//If document is found, store its ObjectID in a JMeter variable
    	vars.put("exampleDocumentId", result.get("_id").toString());

    	return"Document in the Communication Equipments sector found" 
    }
    catch(Exception e) {
    	SampleResult.setSuccessful(false);
    	SampleResult.setResponseCode("500");
    	SampleResult.setResponseMessage("Exception: "+ e);
    }