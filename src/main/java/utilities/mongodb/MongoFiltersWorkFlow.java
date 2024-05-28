package utilities.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class MongoFiltersWorkFlow {

    public static String filterFirstMongoObjectAndReturnJsonString(String fieldPath, Object textSearch,
                                                                   MongoCollection<Document> collectionName){

        String mongoObject = null;
        Bson e = MongoBsonFilterTypes.equalFilter(fieldPath,textSearch);
        if (MongoDBActions.checkIfCollectionNotEmpty(collectionName,e)){
            for (Document doc : collectionName.find(e)){
                mongoObject = doc.toJson();
            }
        }
        return mongoObject;
    }

    public static String filterFirstMongoObjectAndReturnJsonString(String fieldPath1, Object textSearch1, String fieldPath2,
                                                                   Object textSearch2, MongoCollection<Document> collectionName){

        String mongoObject = null;
        Bson e = MongoBsonFilterTypes.equalFilterTwoFields(fieldPath1,textSearch1,fieldPath2,textSearch2);
        if (MongoDBActions.checkIfCollectionNotEmpty(collectionName,e)){
            for (Document doc : collectionName.find(e)){
                mongoObject = doc.toJson();
            }
        }
        return mongoObject;
    }

    public static Document filterFirstMongoObjectAndReturnDocument(String fieldPath, Object textSearch,
                                                                   MongoCollection<Document> collectionName){

        Bson filter = MongoBsonFilterTypes.equalFilter(fieldPath,textSearch);
        return MongoDBActions.getFirstDocument(collectionName,filter);
    }

    public static ArrayList<String> filterFirstMongoObjectAndReturnJsonArrayString(String fieldPath, Object textSearch,
                                                                   MongoCollection<Document> collectionName){

        Bson filter = MongoBsonFilterTypes.equalFilter(fieldPath,textSearch);
        return MongoDBActions.getAllDocumentsAsJsonArray(collectionName,filter);
    }

    public static ArrayList<String> filterFirstMongoObjectAndReturnJsonArrayString(String fieldPath1, Object textSearch1, String fieldPath2,
                                                                   Object textSearch2, MongoCollection<Document> collectionName){

        ArrayList<String> arrayList = new ArrayList<>();
        Bson e = MongoBsonFilterTypes.equalFilterTwoFields(fieldPath1,textSearch1,fieldPath2,textSearch2);
        if (MongoDBActions.checkIfCollectionNotEmpty(collectionName,e)){
            for (Document doc : collectionName.find(e)){
                arrayList.add(doc.toJson());
            }
        }
        return arrayList;
    }

    public static boolean filterAndCheckIfDataReturns(String fieldPath, Object textSearch,
                                                                   MongoCollection<Document> collectionName){

        Bson filter = MongoBsonFilterTypes.equalFilter(fieldPath,textSearch);
        return MongoDBActions.checkIfCollectionNotEmpty(collectionName,filter);
    }

    public static boolean filterAndCheckIfDataReturns(String fieldPath1, Object textSearch1, String fieldPath2, Object textSearch2,
                                                      MongoCollection<Document> collectionName){

        Bson filter = MongoBsonFilterTypes.equalFilterTwoFields(fieldPath1,textSearch1,fieldPath2,textSearch2);
        return MongoDBActions.checkIfCollectionNotEmpty(collectionName,filter);
    }

}
