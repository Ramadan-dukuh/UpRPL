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
    
    public DefaultTableModel tampilkanTransaksiAccepted() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("ID Produk");
        model.addColumn("Jumlah Permintaan");
        model.addColumn("Tanggal Permintaan");
        model.addColumn("Nama Suplier");
        
        String sql = "SELECT idTrsuplier, idProduk, jumlah, tglRestock, nmSuplier FROM transaksi_suplier WHERE status = 'Accepted'";

        try (PreparedStatement ps = kon.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("idTrsuplier"),
                    rs.getString("idProduk"),
                    rs.getInt("jumlah"),
                    rs.getString("tglRestock"),
                    rs.getString("nmSuplier")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data transaksi accepted: " + e.getMessage());
        } return model;
    } 
}
