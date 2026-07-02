package repository;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {

    public boolean login(String username, String password) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Repository error: " + e.getMessage());
            return false;
        }
    }
}