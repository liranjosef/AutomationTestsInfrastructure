package utilities.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import utilities.dates.DateFormat;
import utilities.json.JsonStringsCompare;

import java.util.Collections;
import java.util.Date;

public class MongoFullProcess {

    public static void filterAndInsertAndDeleteFromCollection(String untilISODate, String datePath,
                                                              MongoCollection<Document> collectionToDeleteFrom,
                                                              MongoCollection<Document> collectionToInsertTo){
        Date date = DateFormat.createISODate(untilISODate);
        Bson filter = MongoBsonFilterTypes.untilFilter(datePath,date);
        int i = 0;
        if (MongoDBActions.checkIfCollectionNotEmpty(collectionToDeleteFrom,filter)){
            for (Document document : collectionToDeleteFrom.find(filter)){
                i++;
                System.out.println(i);
                collectionToInsertTo.insertOne(document);
                Bson documentFilter = MongoBsonFilterTypes.equalFilter("_id", document.get("_id"));
                Document documentAfterInsert = collectionToInsertTo.find(documentFilter).first();
                if (JsonStringsCompare.assertJsonEquality(documentAfterInsert.toJson(),document.toJson(), Collections.singletonList(""),
                        "Assert Jsons")){
                    collectionToDeleteFrom.deleteOne(documentFilter);
                    System.out.println("document number " +i+" : " + document.get("_id") + " Deleted");
                }else {
                    System.out.println("document number " +i+" : " + document.get("_id") + " not Inserted well");
                }
            }
        }
        System.out.println(i);
    }
}
