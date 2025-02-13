package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;

public class DashboardDao {
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    
    public DashboardDao() {
        kon = getConnection();
    }
    
    public DefaultTableModel getStockData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga");
        
        try {
            ps = kon.prepareStatement("SELECT idProduk, nmProduk, jenisProduk, stock, hargaJual FROM produk WHERE stock > 0 OR jenisProduk = 'jasa' ");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("idProduk");
                row[1] = rs.getString("nmProduk");
                row[2] = rs.getString("jenisProduk");
                row[3] = rs.getInt("hargaJual");
                
                model.addRow(row);
            }
        } catch (SQLException se) {
            System.out.println("Error : " + se);
        }
        
        return model;
    }
    public int getTotalPetugas(){
        int total = 0;
        try{
            ps = kon.prepareStatement("SELECT COUNT(*) AS total_petugas FROM petugas");
            rs = ps.executeQuery();
            if (rs.next()) {
            total = rs.getInt("total_petugas");
        }
    } catch (SQLException se) {
        System.out.println("Error : " + se);
    }
    return total;
    }
    
    public int getTotalStock(){
        int total = 0;
        try{
            ps = kon.prepareStatement("SELECT SUM(stock) AS total_stock FROM produk");
            rs = ps.executeQuery();
            if (rs.next()) {
            total = rs.getInt("total_stock");
        }
    } catch (SQLException se) {
        System.out.println("Error : " + se);
    }
    return total;
    }
}
