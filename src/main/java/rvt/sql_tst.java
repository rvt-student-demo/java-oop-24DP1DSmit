package rvt;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class sql_tst {
    public static void main(String[] args) {
        try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
            Statement stmt = connection.createStatement();
        ){
            String sql = "CREATE TABLE IF NOT EXISTS todo ("
            + "id INTEGER PRIMARY KEY," 
            + " task TEXT NOT NULL) STRICT" ;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
