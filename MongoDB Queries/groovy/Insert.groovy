import com.mongodb.client.MongoCollection;
import org.bson.Document;

try {
    // Retrieve MongoDB collection from JMeter variables
    MongoCollection<Document> collection = vars.getObject("collection");

    // Create a new document with the desired fields and values
    Document newDocument = new Document()
        .append("Company Name", "Doofenshmirtz Evil Inc")
        .append("Industry", "World Domination")
        .append("Sector", "Weapons Manufacturing")
        .append("HQ State", "New York")
        .append("Founding Year", 2007)
        .append("Annual Revenue 2022-2023 (USD in Billions)", 0)
        .append("Market Cap (USD in Trillions)", 0)
        .append("Stock Name", "EVIL")
        .append("Annual Income Tax in 2022-2023", 0)
        .append("Employee Size", 2);
      
    // Insert the new document into the collection
    collection.insertOne(newDocument);

    return "New document inserted successfully";
    
} catch (Exception e) {
    SampleResult.setSuccessful(false);
    SampleResult.setResponseCode("500");
    SampleResult.setResponseMessage("Exception: " + e);
}