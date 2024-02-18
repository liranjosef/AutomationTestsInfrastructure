package base.google;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rabbitmq.client.Channel;
import org.bson.Document;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public abstract class BaseGoogle {

    protected static String configurationFilePath = System.getProperty("user.dir") +
            "\\src\\main\\resources\\configurationFiles\\google\\configurationFile.xml";
    protected static String environment;
    protected static String environmentBaseUrl;
    protected static String fullUrl;
    protected static String platformName;
    protected static String browserType;

    //SQL
    protected static String dbUrl;
    protected static String userName;
    protected static String password;
    protected static Connection connection;
    protected static ResultSet result;
    protected static ResultSetMetaData resultSetMetaData;

    //MongoDB
    protected static String mongoURI;
    protected static String mongoDBName;
    protected static MongoClientURI mongoClientURI;
    protected static MongoClient mongoClient;
    protected static MongoDatabase db;
    protected static MongoCollection<Document> googleCollection;

    //RabbitMQ
    protected static Channel channel;


}
