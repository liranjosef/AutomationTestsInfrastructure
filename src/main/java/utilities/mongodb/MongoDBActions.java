package utilities.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class MongoDBActions {

    public static boolean checkIfCollectionNotEmpty(MongoCollection<Document> collection, Bson filter){

        return collection.find(filter).iterator().hasNext();
    }

    public static String getFirstDocumentAsJson(MongoCollection<Document> collection, Bson filter){
        if (checkIfCollectionNotEmpty(collection,filter)){
            return collection.find(filter).first().toJson();
        }else{
            System.out.println("collection is empty");
            return null;
        }
    }

    public static Document getFirstDocument(MongoCollection<Document> collection, Bson filter){
        if (checkIfCollectionNotEmpty(collection,filter)){
            return collection.find(filter).first();
        }else{
            System.out.println("collection is empty");
            return null;
        }
    }

    public static long getDocumentsCount(MongoCollection<Document> collection, Bson filter){
        long count = 0;
        if (checkIfCollectionNotEmpty(collection,filter)){
            count = collection.countDocuments(filter);
        }
        return count;
    }

    public static ArrayList<String> getAllDocumentsAsJsonArray(MongoCollection<Document> collection, Bson filter){
        ArrayList<String> arrayList = new ArrayList<>();
        if (checkIfCollectionNotEmpty(collection,filter)){
            for (Document document : collection.find(filter)){
                arrayList.add(document.toJson());
            }
        }
        return arrayList;
    }


}
