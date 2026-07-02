import database.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("Koneksi database BERHASIL!");
        } else {
            System.out.println("Koneksi database GAGAL!");
        }

    }
}