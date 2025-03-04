package Dao;

import koneksi.Koneksi;
import model.Produk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;
import model.Transaksi_suplier;

public class TransaksiSuplierDao {
    Connection kon;
    PreparedStatement ps;

    public TransaksiSuplierDao() {
        kon = getConnection();
    }
    
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
   public boolean buatTransaksi(Transaksi_suplier transaksi) {
        String query = "INSERT INTO transaksi_suplier(kodeSuplier, id_trsup, idProduk, jumlah) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = kon.prepareStatement(query)) {
            ps.setString(1, transaksi.getKodeSuplier());
            ps.setString(2, transaksi.getId_trsup());
            ps.setString(3, transaksi.getId_produk());
            ps.setString(4, transaksi.getJumlah());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0; // Return true jika berhasil
        } catch (SQLException e) {
            e.printStackTrace(); // Untuk debugging, bisa diganti dengan logging
            return false;
        }
    }
}
