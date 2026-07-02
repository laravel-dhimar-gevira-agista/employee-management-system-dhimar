package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            // WAJIB ADD INI
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Koneksi database gagal!");
            e.printStackTrace();

            return null;
        }
    }
}