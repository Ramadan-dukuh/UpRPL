package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class LpKeuanganDao {
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;

    public LpKeuanganDao() {
        kon = Koneksi.getConnection();
    }

    // Fungsi untuk format Rupiah
    private String formatRupiah(int angka) {
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return rupiahFormat.format(angka);
    }

    public int getTotalPendapatan() {
        int totalPendapatan = 0;
        String sql = "SELECT SUM(hargaJual * stock) AS totalPendapatan FROM produk";

        try {
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalPendapatan = rs.getInt("totalPendapatan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPendapatan;
    }

    public int getTotalModal() {
        int totalModal = 0;
        String sql = "SELECT SUM(hargaBeli * stock) AS totalModal FROM produk";

        try {
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalModal = rs.getInt("totalModal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalModal;
    }

    // Menghitung total pengeluaran berdasarkan transaksi supplier
    public int getTotalPengeluaran() {
        int totalPengeluaran = 0;
        String sql = "SELECT SUM(hargaBeli * jumlah) AS totalPengeluaran FROM transaksi_supplier";

        try {
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalPengeluaran = rs.getInt("totalPengeluaran");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPengeluaran;
    }

    public int getTotalKeuntungan() {
        return getTotalPendapatan() - getTotalModal();
    }

    public int getLabaBersih() {
        return getTotalKeuntungan() - getTotalPengeluaran();
    }

    // Menampilkan laporan keuangan dalam JTable
    public DefaultTableModel getTableLaporanKeuangan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Deskripsi");
        model.addColumn("Jumlah (Rp)");

        model.addRow(new Object[]{"Total Pendapatan", formatRupiah(getTotalPendapatan())});
        model.addRow(new Object[]{"Total Modal", formatRupiah(getTotalModal())});
        model.addRow(new Object[]{"Total Pengeluaran", formatRupiah(getTotalPengeluaran())});
        model.addRow(new Object[]{"Total Keuntungan", formatRupiah(getTotalKeuntungan())});
        model.addRow(new Object[]{"Laba Bersih", formatRupiah(getLabaBersih())});

        return model;
    }
}
