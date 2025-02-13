package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;

public class ProdukDao {
    
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    
    public ProdukDao() {
        kon = getConnection();
    }
    
    public DefaultTableModel getProduct(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stock");
        
        String query = "SELECT idProduk, nmProduk, jenisProduk, hargaBeli, hargaJual, stock FROM produk";
        
        try {
            ps = kon.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("idProduk"),
                    rs.getString("nmProduk"),
                    rs.getString("jenisProduk"),
                    rs.getDouble("hargaBeli"),
                    rs.getDouble("hargaJual"),
                    rs.getInt("stock")
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
}
