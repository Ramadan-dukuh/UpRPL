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

    // Menghitung pendapatan berdasarkan bulan & tahun
    // Ambil dari view 'transaksi_view' yang sudah menjumlahkan total
    public int getTotalPendapatan(int bulan, int tahun) {
        int totalPendapatan = 0;
        String sql = "SELECT SUM(total) AS totalPendapatan " +
                     "FROM transaksi_view " +
                     "WHERE MONTH(tglTransaksi) = ? AND YEAR(tglTransaksi) = ?";

        try {
            ps = kon.prepareStatement(sql);
            ps.setInt(1, bulan);
            ps.setInt(2, tahun);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalPendapatan = rs.getInt("totalPendapatan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPendapatan;
    }

    // Ambil dari tabel pengeluaran
    public int getTotalPengeluaran(int bulan, int tahun) {
        int totalPengeluaran = 0;
        String sql = "SELECT SUM(total) AS totalPengeluaran " +
                     "FROM pengeluaran " +
                     "WHERE MONTH(tglRestock) = ? AND YEAR(tglRestock) = ?";

        try {
            ps = kon.prepareStatement(sql);
            ps.setInt(1, bulan);
            ps.setInt(2, tahun);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalPengeluaran = rs.getInt("totalPengeluaran");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPengeluaran;
    }



    // Menghitung modal berdasarkan bulan & tahun
  // Menghitung total modal berdasarkan bulan & tahun
public int getTotalModal(int bulan, int tahun) {
    int totalModal = 0;
    String sql = "SELECT SUM(ts.jumlah * p.hargaBeli) AS totalModal " +
                 "FROM transaksi_suplier ts " +
                 "JOIN transaksi t ON ts.idTrsuplier = t.noOrder " + 
                 "JOIN produk p ON ts.idProduk = p.idProduk " +
                 "WHERE MONTH(t.tglTransaksi) = ? AND YEAR(t.tglTransaksi) = ?";

    try {
        ps = kon.prepareStatement(sql);
        ps.setInt(1, bulan);
        ps.setInt(2, tahun);
        rs = ps.executeQuery();
        if (rs.next()) {
            totalModal = rs.getInt("totalModal");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return totalModal;
}

    // Menghitung total keuntungan per bulan (pendapatan - modal)
   // Pemasukan kotor (total penjualan)
    public int getPemasukanKotor(int bulan, int tahun) {
        return getTotalPendapatan(bulan, tahun);
    }

    // Total keuntungan (pendapatan - modal)
    public int getTotalKeuntungan(int bulan, int tahun) {
        return getTotalPendapatan(bulan, tahun) - getTotalModal(bulan, tahun);
    }

    // Laba bersih (keuntungan - pengeluaran)
    public int getLabaBersih(int bulan, int tahun) {
        return getTotalKeuntungan(bulan, tahun) - getTotalPengeluaran(bulan, tahun);
    }

    // Laba bersih (pendapatan - pengeluaran)
    public DefaultTableModel getTableLaporanKeuangan(int bulan, int tahun) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Deskripsi");
        model.addColumn("Jumlah (Rp)");

        // Ubah label supaya lebih akrab untuk user
        model.addRow(new Object[]{"Pemasukan Kotor", formatRupiah(getTotalPendapatan(bulan, tahun))});
        model.addRow(new Object[]{"Pengeluaran", formatRupiah(getTotalPengeluaran(bulan, tahun))});
        model.addRow(new Object[]{"Pemasukan Bersih", formatRupiah(getLabaBersih(bulan, tahun))});

        // (Opsional tambahan untuk akuntansi lebih detail)
        model.addRow(new Object[]{"Total Keuntungan", formatRupiah(getTotalKeuntungan(bulan, tahun))});

        return model;
    }
}
