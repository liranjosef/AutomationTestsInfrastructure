package platforms.mongodb.google;

import base.google.BaseGoogle;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoInit extends BaseGoogle {

    public static void mongo_init(){

        platformName = "mongo";
        System.out.println(platformName);
        initMongoEnvironmentVariables();
        initMongoDB();
        initCollections();


    }

    public static void initMongoEnvironmentVariables(){
        if (environment.equalsIgnoreCase("test")){
            mongoURI = "";
        } else if (environment.equalsIgnoreCase("preProd")) {
            mongoURI = "";
        } else if (environment.equalsIgnoreCase("prod")) {
            mongoURI = "";
        }
    }

    public static void initMongoDB(){
        mongoDBName = "x";
        mongoClientURI = new MongoClientURI(mongoURI);
        mongoClient = new MongoClient(mongoClientURI);
        db = mongoClient.getDatabase(mongoDBName);
    }

    public static void initCollections(){
        googleCollection = db.getCollection("x");

    }
}
