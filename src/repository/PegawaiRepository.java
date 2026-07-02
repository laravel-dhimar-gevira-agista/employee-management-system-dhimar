package repository;

import database.DatabaseConnection;
import entity.Pegawai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PegawaiRepository {

    public List<Pegawai> getAll() {
        List<Pegawai> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM pegawai";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pegawai p = new Pegawai();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setJabatan(rs.getString("jabatan"));
                p.setDivisi(rs.getString("divisi"));
                p.setGaji(rs.getDouble("gaji"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Pegawai p) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO pegawai (nama, jabatan, divisi, gaji) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNama());
            ps.setString(2, p.getJabatan());
            ps.setString(3, p.getDivisi());
            ps.setDouble(4, p.getGaji());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Pegawai p) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE pegawai SET nama=?, jabatan=?, divisi=?, gaji=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNama());
            ps.setString(2, p.getJabatan());
            ps.setString(3, p.getDivisi());
            ps.setDouble(4, p.getGaji());
            ps.setInt(5, p.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM pegawai WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}