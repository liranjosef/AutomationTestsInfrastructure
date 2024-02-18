package utilities.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBActions {

    public static MongoCollection<Document> getCollection(MongoDatabase db, String collectionName){

        return db.getCollection(collectionName);
    }

    public static boolean checkIfCollectionNotEmpty(MongoCollection<Document> collection, Bson filter){

        return collection.find(filter).iterator().hasNext();
    }
}
