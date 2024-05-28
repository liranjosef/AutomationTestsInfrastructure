package utilities.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLActions {


    public static ResultSet getResult(Connection connection, String query){

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> getColumnResults(ResultSet result, int columnNumber) throws SQLException {
        ArrayList<String> columnResults = new ArrayList<>();
        while (result.next()){
            columnResults.add(result.getString(columnNumber));
        }
        return columnResults;

    }
}
