/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.LpTransaksiDao;
import LookUp.ShowProduk;
import dao.TransaksiPemesananDao;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Detail_transaksi;
import model.Transaksi;



/**
 *
 * @author Hp
 */
public class MenuTransaksiPemesanan extends javax.swing.JPanel {

    LpTransaksiDao dao = new LpTransaksiDao();
    ShowProduk showProduk = new ShowProduk(new javax.swing.JFrame(), true);
    
    /**
     * Creates new form MenuLaporanTransaksi
     */
    public MenuTransaksiPemesanan() {
        initComponents();
        setTableModel();
        kosong();
        setTgl();
    }
    public void setTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID Produk", "Nama Produk", "Jumlah", "Harga", "Tanggal", "Nama Pelanggan"});
        tblBarang.setModel(model);
    }

    public void totalBiaya(){
        int jumlahBaris = tblBarang.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tblBarang.getValueAt(i, 2).toString());
            hargaBarang = Integer.parseInt(tblBarang.getValueAt(i, 3).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txtTotal.setText(String.valueOf(totalBiaya));
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void setTgl() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Format tanggal
        String tanggalHariIni = sdf.format(new Date()); // Ambil tanggal hari ini
        txtTanggal.setText(tanggalHariIni); // Set ke JTextField
    }

    public void clear2(){
        txtIDProduk.setText("");
        txtProduk.setText("");
        txtHargaProduk.setText("");
        jmlBeli.setValue(0);
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
        model.addRow(new Object[]{
            txtIDProduk.getText(),
            txtProduk.getText(),
            jmlBeli.getValue(),
            txtHargaProduk.getText(),
            txtTanggal.getText(),
            txtPelanggan.getText()
        });
    }

    
    public void tambahTransaksi(){
        // Cek apakah jumlah sudah diisi
        if (jmlBeli.getValue() == null || (int) jmlBeli.getValue() <= 0) {
            JOptionPane.showMessageDialog(this, "Jumlah barang harus lebih dari 0!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Cek apakah harga kosong atau tidak valid
        String hargaText = txtHargaProduk.getText().trim();
        if (hargaText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga produk tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int jumlah = (int) jmlBeli.getValue();
            int harga = Integer.parseInt(hargaText);
            int total = jumlah * harga;

            txtTotal.setText(String.valueOf(total));

            // Tambahkan data ke tabel
            loadData();
            totalBiaya();
            clear2();
            txtIDProduk.requestFocus();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input harga tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProduk2 = new javax.swing.JTextField();
        lblProduk2 = new javax.swing.JLabel();
        txtProduk4 = new javax.swing.JTextField();
        lblProduk4 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        txtPelanggan = new javax.swing.JTextField();
        lblPelanggan = new javax.swing.JLabel();
        txtProduk = new javax.swing.JTextField();
        lblProduk = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmlBeli = new javax.swing.JSpinner();
        txtHargaProduk = new javax.swing.JTextField();
        lblProduk1 = new javax.swing.JLabel();
        txtIDProduk = new javax.swing.JTextField();
        lblIDproduk = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblTanggal = new javax.swing.JLabel();
        btnList = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblProduk3 = new javax.swing.JLabel();

        txtProduk2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblProduk2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProduk2.setText("Harga Satuan");

        txtProduk4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblProduk4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProduk4.setText("ID Produk");

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));
        tampilData.setPreferredSize(new java.awt.Dimension(1038, 621));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Data Pemesanan Barang");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnTambah.setBackground(new java.awt.Color(204, 204, 204));
        btnTambah.setForeground(new java.awt.Color(0, 0, 51));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 204, 204));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(204, 204, 204));
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBarang.setGridColor(new java.awt.Color(0, 0, 51));
        jScrollPane2.setViewportView(tblBarang);

        txtPelanggan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblPelanggan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPelanggan.setText("Nama Pelanggan");

        txtProduk.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtProduk.setEnabled(false);

        lblProduk.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProduk.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Jumlah Beli");

        txtHargaProduk.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtHargaProduk.setEnabled(false);

        lblProduk1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProduk1.setText("Harga Satuan");

        txtIDProduk.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIDProduk.setEnabled(false);

        lblIDproduk.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblIDproduk.setText("ID Produk");

        txtTanggal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTanggal.setEnabled(false);

        lblTanggal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTanggal.setText("Tanggal");

        btnList.setBackground(new java.awt.Color(204, 204, 204));
        btnList.setForeground(new java.awt.Color(0, 0, 51));
        btnList.setText("LIST PRODUK");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTotal.setEnabled(false);

        lblProduk3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProduk3.setText("Total Harga");

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblProduk)
                        .addComponent(lblPelanggan)
                        .addComponent(txtPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtProduk))
                    .addComponent(lblProduk3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                                .addGap(0, 251, Short.MAX_VALUE)
                                .addComponent(btnList)
                                .addGap(40, 40, 40)
                                .addComponent(btnTambah)
                                .addGap(40, 40, 40)
                                .addComponent(btnHapus)
                                .addGap(40, 40, 40))
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tampilDataLayout.createSequentialGroup()
                                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIDproduk))
                                        .addGap(45, 45, 45)
                                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                                                .addComponent(jmlBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnSimpan)
                        .addGap(51, 51, 51))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(lblProduk1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTanggal)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(lblPelanggan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(lblProduk1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblProduk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIDproduk)
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jmlBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnList))
                        .addGap(18, 18, 18))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblProduk3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Transaksi transaksi = new Transaksi();
        transaksi.setTglTransaksi(java.sql.Date.valueOf(txtTanggal.getText())); 
        transaksi.setNmPelanggan(txtPelanggan.getText());

        // Panggil DAO untuk menyimpan transaksi utama
        TransaksiPemesananDao transaksiDAO = new TransaksiPemesananDao();
        String noOrder = transaksiDAO.simpanTransaksi(transaksi);

        if (noOrder != null && !noOrder.isEmpty()) { // Cek apakah transaksi berhasil disimpan
            for (int i = 0; i < tblBarang.getRowCount(); i++) {
                Detail_transaksi detail = new Detail_transaksi();
                detail.setNoOrder(noOrder);
                detail.setIdProduk(tblBarang.getValueAt(i, 0).toString());

                // Validasi jumlah
                String jumlahStr = tblBarang.getValueAt(i, 2).toString();
                if (jumlahStr.isEmpty() || !jumlahStr.matches("\\d+")) {
                    continue; // Lewati jika kosong atau bukan angka
                }
                detail.setJumlah(jumlahStr);

                // Validasi harga
                String hargaStr = tblBarang.getValueAt(i, 3).toString();
                if (hargaStr.isEmpty() || !hargaStr.matches("\\d+")) {
                    continue; // Lewati jika kosong atau bukan angka
                }
                detail.setHarga(hargaStr);

                // Simpan detail transaksi ke database
                transaksiDAO.simpanDetailTransaksi(detail);
            }
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            kosong();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        showProduk.setModal(true);
        showProduk.lblProduk.setText("List Produk");
        showProduk.tblProduk.setModel(dao.getLookProduk());
        showProduk.scrLookup.setViewportView(showProduk.tblProduk);
        showProduk.setVisible(true);
    }//GEN-LAST:event_btnListActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
        int row = tblBarang.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
    }//GEN-LAST:event_btnHapusActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenutView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MenuTransaksiPemesanan(frame).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JSpinner jmlBeli;
    private javax.swing.JLabel lblIDproduk;
    private javax.swing.JLabel lblPelanggan;
    private javax.swing.JLabel lblProduk;
    private javax.swing.JLabel lblProduk1;
    private javax.swing.JLabel lblProduk2;
    private javax.swing.JLabel lblProduk3;
    private javax.swing.JLabel lblProduk4;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tampilData;
    private javax.swing.JTable tblBarang;
    public static javax.swing.JTextField txtHargaProduk;
    public static javax.swing.JTextField txtIDProduk;
    private javax.swing.JTextField txtPelanggan;
    public static javax.swing.JTextField txtProduk;
    private javax.swing.JTextField txtProduk2;
    private javax.swing.JTextField txtProduk4;
    public static javax.swing.JTextField txtTanggal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
