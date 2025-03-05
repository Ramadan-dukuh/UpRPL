package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;
import model.Produk;

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
    
    public DefaultTableModel getProductBySearch(String idProduk) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stock");

        try {
            String query = "SELECT * FROM produk WHERE idProduk LIKE ? OR nmProduk LIKE ?";
            ps = kon.prepareStatement(query);
            ps.setString(1, "%" + idProduk + "%");
            ps.setString(2, "%" + idProduk + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = {
                    rs.getString("idProduk"),
                    rs.getString("nmProduk"),
                    rs.getString("jenisProduk"),
                    rs.getString("hargaBeli"),
                    rs.getString("hargaJual"),
                    rs.getString("stock")
                };
                model.addRow(row);
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
    
    public DefaultTableModel getProductByStock(String filter) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stock");

        String query = "SELECT idProduk, nmProduk, jenisProduk, hargaBeli, hargaJual, stock FROM produk";

        if (filter.equals("Tersedia")){
            query += " WHERE stock > 10";
        }
        else if(filter.equals("Hampir Habis")) {
            query += " WHERE stock < 10 AND stock > 0";
        } else if (filter.equals("Sudah Habis")) {
            query += " WHERE stock = 0";
        } else if (filter.equals("Tampilkan Semua")){
            query += " ";
        }

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
            System.out.println("Error mengambil data produk berdasarkan stok: " + e.getMessage());
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
    
    public void simpanProduk(String nmProduk, String kategori, int hargaBeli, int hargaJual) {
        String query;
        try {
            ps = kon.prepareStatement("SELECT * FROM produk WHERE nmProduk = ?");
            ps.setString(1, nmProduk);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Produk sudah ada, lakukan update
                query = "UPDATE produk SET jenisProduk = ?, hargaBeli = ?, hargaJual = ? WHERE nmProduk = ?";
                ps = kon.prepareStatement(query);
                ps.setString(1, kategori);
                ps.setInt(2, hargaBeli);
                ps.setInt(3, hargaJual);
                ps.setString(4, nmProduk);
            } else {
                // Produk belum ada, lakukan insert
                query = "INSERT INTO produk (nmProduk, jenisProduk, hargaBeli, hargaJual, stock) VALUES (?, ?, ?, ?, 0)";
                ps = kon.prepareStatement(query);
                ps.setString(1, nmProduk);
                ps.setString(2, kategori);
                ps.setInt(3, hargaBeli);
                ps.setInt(4, hargaJual);
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil disimpan.");
            } else {
                System.out.println("Gagal menyimpan data.");
            }

        } catch (SQLException se) {
            System.out.println("Error : " + se);
        }
    }
    
    public DefaultTableModel getPendingTransactions() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("ID Produk");
        model.addColumn("Tanggal Restock");
        model.addColumn("Jumlah"); // Kolom jumlah, tapi nanti disembunyikan

        String sql = "SELECT idTrsuplier, idProduk, jumlah, tglRestock FROM transaksi_suplier WHERE status = 'Pending'";

        try {
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("idTrsuplier"),
                    rs.getString("idProduk"),
                    rs.getString("tglRestock"),
                    rs.getInt("jumlah") // Simpan jumlah di model
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data transaksi: " + e.getMessage());
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
