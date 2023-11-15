import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;


try {
	//Retrieve MongoDB collection from JMeter variable
    	MongoCollection<Document> collection = vars.getObject("collection");

	//Define empty filter (update all documents in collection)
	Document filter = new Document();

	//Define modifications using $set operator to specific fields
    	Document modifications = new Document("\$set", new Document("Industry", "Agriculture").append("HQ State", "Alaska"));

	//Update many documents in collection based on filter and modifications
    	collection.updateMany(filter, modifications);
    		
    	return "All documents in the collection modified";
    	
    }
    
catch(Exception e) {
    	SampleResult.setSuccessful(false);
    	SampleResult.setResponseCode("500");
    	SampleResult.setResponseMessage("Exception: " + e);
    }