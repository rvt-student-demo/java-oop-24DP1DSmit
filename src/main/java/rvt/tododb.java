package rvt;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class tododb {

    private static final String DB_URL = "jdbc:sqlite:data/todo.db";

    public tododb() {
        initSchema();
    }

    Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        File dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        String sql = "CREATE TABLE IF NOT EXISTS todo ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "task TEXT NOT NULL"
                + ")";

        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
}