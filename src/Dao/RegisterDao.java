package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Petugas;
import static koneksi.Koneksi.getConnection;

public class RegisterDao {
    Connection kon;
    PreparedStatement ps;

    public RegisterDao() {
        kon = getConnection();
    }

    public boolean registerPetugas(Petugas petugas) {
        String query = "INSERT INTO petugas (idPetugas, nmPetugas, username, password, kelas, level) VALUES (?, ?, ?, ?, ?, 'Siswa')";
        try {
            ps = kon.prepareStatement(query);
            ps.setString(1, petugas.getIdPetugas());
            ps.setString(2, petugas.getNmPetugas());
            ps.setString(3, petugas.getUsername());
            ps.setString(4, petugas.getPassword());
            ps.setString(5, petugas.getKelas());
//            ps.setString(6, petugas.getLevel());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
