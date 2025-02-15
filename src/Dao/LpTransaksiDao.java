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
public class LpTransaksiDao {
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    
    public LpTransaksiDao() {
        kon = getConnection();
    }
    
    public DefaultTableModel getTransaksi(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Order");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Total");         
        
        String query = "SELECT noOrder, tglTransaksi, nmPelanggan, total FROM transaksi";
        
        try {
            ps = kon.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("noOrder"),
                    rs.getString("tglTransaksi"),
                    rs.getString("nmPelanggan"),
                    rs.getInt("total"),                    
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data Transaksi: " + e.getMessage());
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
    
    public DefaultTableModel getTransaksiBySearch(String noOrder) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Order");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Total");   

        try {
            String query = "SELECT * FROM transaksi WHERE noOrder LIKE ? OR tglTransaksi LIKE ? OR nmPelanggan LIKE ?";
            ps = kon.prepareStatement(query);
            ps.setString(1, "%" + noOrder + "%");
            ps.setString(2, "%" + noOrder + "%");
            ps.setString(3,"%" + noOrder + "%");
            
            rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = {
                    rs.getString("noOrder"),
                    rs.getString("tglTransaksi"),
                    rs.getString("nmPelanggan"),
                    rs.getString("total"), 
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data Transaksi: " + e.getMessage());
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
