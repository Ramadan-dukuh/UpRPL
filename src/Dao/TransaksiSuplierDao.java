package Dao;

import koneksi.Koneksi;
import model.Produk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TransaksiSuplierDao {
    
    public List<Produk> getProdukKurangDari10() {
        List<Produk> listProduk = new ArrayList<>();
        Connection conn = Koneksi.getConnection();
        String sql = "SELECT idProduk, nmProduk, jenisProduk, hargaBeli, hargaJual, stock FROM produk WHERE stock < 10 AND jenisProduk = 'barang' ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produk produk = new Produk();
                produk.setIdProduk(rs.getString("idProduk"));
                produk.setNmProduk(rs.getString("nmProduk"));
                produk.setJenisProduk(rs.getString("jenisProduk"));
                produk.setHargaBeli(rs.getInt("hargaBeli"));
                produk.setHargaJual(rs.getInt("hargaJual"));
                produk.setStock(rs.getInt("stock"));
                
                listProduk.add(produk);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduk;
    }
    
    public void tampilkanProdukKurangDari10(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada di tabel
        List<Produk> listProduk = getProdukKurangDari10();
        
        for (Produk p : listProduk) {
            Object[] rowData = { p.getIdProduk(), p.getNmProduk(), p.getJenisProduk(), p.getHargaBeli(), p.getHargaJual(), p.getStock() };
            model.addRow(rowData);
        }
    }
    
    
}
