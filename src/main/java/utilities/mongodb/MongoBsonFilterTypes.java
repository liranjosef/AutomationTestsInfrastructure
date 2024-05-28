package utilities.mongodb;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import utilities.dates.DateFormat;
import utilities.dates.ISODateActions;

import java.util.Date;

import static com.mongodb.client.model.Filters.*;

public class MongoBsonFilterTypes {

    public static Bson equalFilter(String fieldPath, Object textSearch){

        return eq(fieldPath,textSearch);
    }

    public static Bson equalFilterTwoFields(String fieldPath1, Object textSearch1, String fieldPath2, Object textSearch2){

        return and(eq(fieldPath1,textSearch1),
                Filters.eq(fieldPath2,textSearch2));
    }

    public static Bson betweenTwoFieldsFilter(String fieldPath1, Object textSearch1, String fieldPath2, Object textSearch2){

        return and(gte(fieldPath1,textSearch1),
                Filters.lt(fieldPath2,textSearch2));
    }

    public static Bson untilFilter(String fieldPath, Object value){

        return lt(fieldPath, value);
    }

    public static Bson untilISODateFilter(String fieldPath, String isoDateValue){

        Date date = ISODateActions.createISODateFromStringISODate(isoDateValue);
        return MongoBsonFilterTypes.untilFilter(fieldPath,date);

    }



}
