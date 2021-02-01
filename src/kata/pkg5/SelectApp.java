package kata.pkg5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApp {

    public void selectAll() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        try(
                Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us-500.db");
                Statement statement= connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM people");
            while(result.next()){
                System.out.println(result.getString("first_name") +"\t" +
                        result.getString("last_name") +"\t" +
                        result.getString("company_name") +"\t" +
                        result.getString("city") +"\t" +
                        result.getString("county") +"\t" +
                        result.getString("state") +"\t" +
                        result.getInt("zip") +"\t" +
                        result.getString("phone1") +"\t" +
                        result.getString("phone2") +"\t" +
                        result.getString("email") +"\t" +
                        result.getString("web") +"\t");
            }
        }
    }
}
