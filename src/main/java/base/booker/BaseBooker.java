package base.booker;

public abstract class BaseBooker {

    protected static String configurationFilePath = System.getProperty("user.dir") +
            "\\src\\main\\resources\\configurationFiles\\booker\\configurationFile.xml";
    protected static String environment;
    protected static String environmentBaseUrl;
    protected static String fullUrl;
    protected static String platformName;
    protected static String browserType;

    //API
    protected static String jsonString;
    protected static String ping;
    protected static String createToken;
    protected static String urlGetSpecific;
    protected static String urlGetAll;
    protected static String urlPost;
    protected static String urlPut;
    protected static String urlPatch;
    protected static String urlDelete;


    protected static String bookingId;




}
