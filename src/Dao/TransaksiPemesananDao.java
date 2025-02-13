package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public String generateAutoNumber() {
        String noTransaksi = "TR0001";
        try {
            String sql = "SELECT noOrder FROM transaksi ORDER BY NoFaktur DESC LIMIT 1";
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String lastNo = rs.getString("noOrder").substring(2);
                int newNo = Integer.parseInt(lastNo) + 1;
                noTransaksi = "TR" + String.format("%04d", newNo);
            }
        } catch (SQLException e) {
            System.out.println("Autonumber error: " + e.getMessage());
        }
        return noTransaksi;
    }
    
    public void simpanTransaksi(Transaksi transaksi, DefaultTableModel model) {
        try {
            String sql = "INSERT INTO transaksi (noOrder, tglTransaksi, nmPelanggan, total) VALUES (?, ?, ?, ?)";
            ps = kon.prepareStatement(sql);
            ps.setString(1, transaksi.getNoOrder());
            ps.setDate(2, transaksi.getTglTransaksi());
            ps.setString(3, transaksi.getNmPelanggan());
            ps.setInt(4, transaksi.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Simpan penjualan error: " + e.getMessage());
        }
        
        try {
            for (int i = 0; i < model.getRowCount(); i++) {
                String sql = "INSERT INTO detail_transaksi (Id, noOrder, idProduk, harga, jumlah) VALUES (?, ?, ?, ?, ?)";
                ps = kon.prepareStatement(sql);
                for (int j = 0; j < 5; j++) {
                    ps.setString(j + 1, model.getValueAt(i, j).toString());
                }
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Simpan penjualanrinci error: " + e.getMessage());
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
                detail.setId(rs.getString("id"));
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