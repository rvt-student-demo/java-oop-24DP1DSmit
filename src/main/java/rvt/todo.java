package rvt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class todo {
    private final tododb db;

    public todo() {
        this.db = new tododb();
    }

    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES(?)";
        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void list() {
        String sql = "SELECT id, task FROM todo ORDER BY id";
        try (Connection conn = db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                System.out.println(id + ": " + task);
            }
        } catch (SQLException e) {
            System.out.println("Error listing tasks: " + e.getMessage());
        }
    }

    public ArrayList<String> getAllTasks() {
        ArrayList<String> tasks = new ArrayList<>();
        String sql = "SELECT task FROM todo ORDER BY id";
        try (Connection conn = db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(rs.getString("task"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading tasks: " + e.getMessage());
        }
        return tasks;
    }

    public void remove(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        try (Connection conn = db.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int deletedRows = pstmt.executeUpdate();
            if (deletedRows == 0) {
                System.out.println("Invalid ID");
            }
        } catch (SQLException e) {
            System.out.println("Error removing task: " + e.getMessage());
        }
    }
}