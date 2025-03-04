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
public int getTotalPendapatan(int bulan, int tahun) {
    int totalPendapatan = 0;
    String sql = "SELECT SUM(detail_transaksi.harga * detail_transaksi.jumlah) AS totalPendapatan " +
                 "FROM transaksi " +
                 "JOIN detail_transaksi ON transaksi.noOrder = detail_transaksi.noOrder " +
                 "JOIN produk ON detail_transaksi.idProduk = produk.idProduk " +
                 "WHERE MONTH(transaksi.tglTransaksi) = ? AND YEAR(transaksi.tglTransaksi) = ?";

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


    // Menghitung modal berdasarkan bulan & tahun
  // Menghitung total modal berdasarkan bulan & tahun
public int getTotalModal(int bulan, int tahun) {
    int totalModal = 0;
    String sql = "SELECT SUM(ts.jumlah * p.hargaBeli) AS totalModal " +
                 "FROM transaksi_suplier ts " +
                 "JOIN transaksi t ON ts.id_trsup = t.noOrder " + 
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

// Menghitung total pengeluaran berdasarkan bulan & tahun
public int getTotalPengeluaran(int bulan, int tahun) {
    return getTotalModal(bulan, tahun);
}



    // Menghitung total keuntungan per bulan (pendapatan - modal)
    public int getTotalKeuntungan(int bulan, int tahun) {
        return getTotalPendapatan(bulan, tahun) - getTotalModal(bulan, tahun);
    }

    // Menghitung laba bersih per bulan (keuntungan - pengeluaran)
    public int getLabaBersih(int bulan, int tahun) {
        return getTotalKeuntungan(bulan, tahun) - getTotalPengeluaran(bulan, tahun);
    }

    // Menampilkan laporan keuangan berdasarkan bulan dan tahun di JTable
    public DefaultTableModel getTableLaporanKeuangan(int bulan, int tahun) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Deskripsi");
        model.addColumn("Jumlah (Rp)");

        model.addRow(new Object[]{"Total Pendapatan", formatRupiah(getTotalPendapatan(bulan, tahun))});
        model.addRow(new Object[]{"Total Modal", formatRupiah(getTotalModal(bulan, tahun))});
        model.addRow(new Object[]{"Total Pengeluaran", formatRupiah(getTotalPengeluaran(bulan, tahun))});
        model.addRow(new Object[]{"Total Keuntungan", formatRupiah(getTotalKeuntungan(bulan, tahun))});
        model.addRow(new Object[]{"Laba Bersih", formatRupiah(getLabaBersih(bulan, tahun))});

        return model;
    }
}
