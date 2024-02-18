package platforms.sql;

import base.google.BaseGoogle;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInit extends BaseGoogle {

    public static void sql_init(){

        platformName = "sql";
        initSQLEnvironmentVariables();
        try {
            connection = DriverManager.getConnection(dbUrl,userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDBConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initSQLEnvironmentVariables(){
        if (environment.equalsIgnoreCase("test")){
            dbUrl= "";
            userName= "";
            password= "";
        } else if (environment.equalsIgnoreCase("preProd")) {
            dbUrl= "";
            userName= "";
            password= "";
        } else if (environment.equalsIgnoreCase("prod")) {
            dbUrl= "";
            userName= "";
            password= "";
        }
    }
}
