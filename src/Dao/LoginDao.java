package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static koneksi.Koneksi.getConnection;
import model.Petugas;

public class LoginDao {
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    
    public LoginDao(){
        kon = getConnection();
    }
    
    public Petugas getPetugas(String username) {
        Petugas petugas = null;
        try {
            ps = kon.prepareStatement("SELECT idPetugas, username, password,kelas FROM petugas WHERE username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                petugas = new Petugas();
                petugas.setIdPetugas(rs.getString("idPetugas"));
                petugas.setUsername(rs.getString("username"));
                petugas.setPassword(rs.getString("password"));
                petugas.setKelas(rs.getString("kelas"));
            }
        } catch (SQLException se) {
            System.out.println("Error : " + se);
        }
        return petugas;
    }
}
