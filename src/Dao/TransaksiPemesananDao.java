package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static koneksi.Koneksi.getConnection;
import model.Transaksi;
import model.Detail_transaksi;

public class TransaksiPemesananDao {
    private Connection kon;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public TransaksiPemesananDao() {
        kon = getConnection();
    }
    
    
    public String simpanTransaksi(Transaksi transaksi) {
        String noOrder = null;
        try {
            // Simpan transaksi utama (tanpa memasukkan noOrder karena dibuat oleh trigger)
            String sql = "INSERT INTO transaksi (tglTransaksi, nmPelanggan) VALUES (?, ?)";
            ps = kon.prepareStatement(sql);
            ps.setDate(1, transaksi.getTglTransaksi());
            ps.setString(2, transaksi.getNmPelanggan());

            if (ps.executeUpdate() > 0) {
                // Ambil noOrder terbaru dari database
                String sqlGetNoOrder = "SELECT noOrder FROM transaksi ORDER BY noOrder DESC LIMIT 1";
                ps = kon.prepareStatement(sqlGetNoOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    noOrder = rs.getString("noOrder");
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Simpan transaksi error: " + e.getMessage());
        }
        return noOrder;
    }

    public void simpanDetailTransaksi(Detail_transaksi detail) {
        try {
            String sql = "INSERT INTO detail_transaksi (noOrder, idProduk, jumlah, harga) VALUES (?, ?, ?, ?)";
            ps = kon.prepareStatement(sql);
            ps.setString(1, detail.getNoOrder());
            ps.setString(2, detail.getIdProduk());
            ps.setString(3, detail.getJumlah());
            ps.setString(4, detail.getHarga());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Simpan detail transaksi error: " + e.getMessage());
        }
    }

    public ArrayList<Detail_transaksi> getDetailTransaksi(String noFaktur) {
        ArrayList<Detail_transaksi> listDetail = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detail_transaksi WHERE Id = ?";
            ps = kon.prepareStatement(sql);
            ps.setString(1, noFaktur);
            rs = ps.executeQuery();
            while (rs.next()) {
                Detail_transaksi detail = new Detail_transaksi();
                detail.setId(rs.getString("Id"));
                detail.setNoOrder(rs.getString("noOrder"));
                detail.setIdProduk(rs.getString("idProduk"));
                detail.setJumlah(rs.getString("Jumlah"));
                listDetail.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil detail transaksi: " + e.getMessage());
        }
        return listDetail;
    }
}