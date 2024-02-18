package utilities.mongodb;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class MongoDBFilterTypes {

    public static Bson equalFilter(String fieldPath, Object textSearch){

        return eq(fieldPath,textSearch);
    }

    public static Bson equalFilter(String fieldPath1, Object textSearch1, String fieldPath2, Object textSearch2){

        return and(eq(fieldPath1,textSearch1),
                Filters.eq(fieldPath2,textSearch2));
    }
}
