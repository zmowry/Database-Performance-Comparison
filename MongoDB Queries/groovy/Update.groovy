import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;


try {
	//Retrieve MongoDB collection from JMeter variable
    	MongoCollection<Document> collection = vars.getObject("collection");

	//Define  filter 
	Document filter = new Document("HQ State", "Arizona");

	//Define modifications using $set operator to specific fields
    	Document modifications = new Document("\$set", new Document("HQ State", "Not Arizona"));

	//Update many documents in collection based on filter and modifications
    	collection.updateMany(filter, modifications);
    		
    	return "Documents modified";
    	
    }
    
catch(Exception e) {
    	SampleResult.setSuccessful(false);
    	SampleResult.setResponseCode("500");
    	SampleResult.setResponseMessage("Exception: " + e);
    }
