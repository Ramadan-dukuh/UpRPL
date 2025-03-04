/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;

/**
 *
 * @author Hp
 */
public class PetugasDao {
      Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    
    public PetugasDao() {
        kon = getConnection();
    }
    public DefaultTableModel getPetugas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Kelas");
        model.addColumn("Level");
        
        String query = "SELECT idPetugas, nmPetugas, username, password, kelas, level FROM petugas";
        
        try {
            ps = kon.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("idPetugas"),
                    rs.getString("nmPetugas"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("kelas"),
                    rs.getString("level")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data produk: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Error saat menutup koneksi: " + e.getMessage());
            }
        }
        
        return model;
    }
    
    public DefaultTableModel getProductBySearch(String idPetugas) {
        DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Kelas");
        model.addColumn("Level");

        try {
            String query = "SELECT * FROM petugas WHERE idPetugas LIKE ? OR nmPetugas LIKE ? OR kelas LIKE ?";
            ps = kon.prepareStatement(query);
            ps.setString(1, "%" + idPetugas + "%");
            ps.setString(2, "%" + idPetugas + "%");
            ps.setString(3, "%" + idPetugas + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = {
                    rs.getString("idPetugas"),
                    rs.getString("nmPetugas"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("kelas"),
                    rs.getString("level")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data petugas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Error saat menutup koneksi: " + e.getMessage());
            }
        }
        return model;
    }
     public DefaultTableModel getProductByLevel(String filter) {
        DefaultTableModel model = new DefaultTableModel();
         model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Kelas");
        model.addColumn("Level");

        String query = "SELECT idPetugas, nmPetugas, username, password, kelas, level FROM petugas";

        if (filter.equals("Guru")){
            query += " WHERE level = 'Guru'";
        }
        else if(filter.equals("Siswa")) {
            query += " WHERE level = 'Siswa'";
        } else if (filter.equals("Suplier")) {
            query += " WHERE level = 'Suplier'";
        } else if (filter.equals("Tampilkan Semua")){
            query += " ";
        }

        try {
            ps = kon.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("idPetugas"),
                    rs.getString("nmPetugas"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("kelas"),
                    rs.getString("level")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data petugas berdasarkan level: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Error saat menutup koneksi: " + e.getMessage());
            }
        }

        return model;
    }   
}
