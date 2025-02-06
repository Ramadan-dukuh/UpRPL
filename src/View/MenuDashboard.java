/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DashboardDao;

/**
 *
 * @author Daffa
 */
public class MenuDashboard extends javax.swing.JPanel {

    /**
     * Creates new form menuDashboard
     */
    public MenuDashboard() {
        initComponents();
        DashboardDao dashboardDao = new DashboardDao();
        jTable1.setModel(dashboardDao.getStockData());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card_stock = new pallet.JPanelRounded();
        lb_stock = new javax.swing.JLabel();
        lb_jumlahStock = new javax.swing.JLabel();
        lb_iconStock = new javax.swing.JLabel();
        card_petugas = new pallet.JPanelRounded();
        lb_petugas = new javax.swing.JLabel();
        lb_jumlahAnggota = new javax.swing.JLabel();
        lb_iconPetugas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1038, 621));

        card_stock.setBackground(new java.awt.Color(153, 204, 255));
        card_stock.setForeground(new java.awt.Color(0, 153, 204));
        card_stock.setPreferredSize(new java.awt.Dimension(271, 165));
        card_stock.setRoundBottomLeft(30);
        card_stock.setRoundBottomRight(30);
        card_stock.setRoundTopLeft(30);
        card_stock.setRoundTopRight(30);

        lb_stock.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lb_stock.setForeground(new java.awt.Color(102, 102, 102));
        lb_stock.setText("Stock");

        lb_jumlahStock.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lb_jumlahStock.setForeground(new java.awt.Color(0, 0, 255));
        lb_jumlahStock.setText("999");

        lb_iconStock.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lb_iconStock.setForeground(new java.awt.Color(0, 0, 255));
        lb_iconStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/boxIcon.png"))); // NOI18N
        lb_iconStock.setText("999");

        javax.swing.GroupLayout card_stockLayout = new javax.swing.GroupLayout(card_stock);
        card_stock.setLayout(card_stockLayout);
        card_stockLayout.setHorizontalGroup(
            card_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_stockLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_jumlahStock)
                    .addComponent(lb_stock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(lb_iconStock, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        card_stockLayout.setVerticalGroup(
            card_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_stockLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lb_stock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_jumlahStock)
                .addGap(27, 27, 27))
            .addGroup(card_stockLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_iconStock)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        card_petugas.setBackground(new java.awt.Color(153, 204, 255));
        card_petugas.setForeground(new java.awt.Color(0, 153, 204));
        card_petugas.setPreferredSize(new java.awt.Dimension(271, 165));
        card_petugas.setRoundBottomLeft(30);
        card_petugas.setRoundBottomRight(30);
        card_petugas.setRoundTopLeft(30);
        card_petugas.setRoundTopRight(30);

        lb_petugas.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lb_petugas.setForeground(new java.awt.Color(102, 102, 102));
        lb_petugas.setText("Petugas");

        lb_jumlahAnggota.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lb_jumlahAnggota.setForeground(new java.awt.Color(0, 0, 255));
        lb_jumlahAnggota.setText("999");

        lb_iconPetugas.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lb_iconPetugas.setForeground(new java.awt.Color(0, 0, 255));
        lb_iconPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/personIcon.png"))); // NOI18N
        lb_iconPetugas.setText("999");

        javax.swing.GroupLayout card_petugasLayout = new javax.swing.GroupLayout(card_petugas);
        card_petugas.setLayout(card_petugasLayout);
        card_petugasLayout.setHorizontalGroup(
            card_petugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_petugasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card_petugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_jumlahAnggota)
                    .addComponent(lb_petugas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lb_iconPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        card_petugasLayout.setVerticalGroup(
            card_petugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_petugasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lb_petugas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_jumlahAnggota)
                .addGap(27, 27, 27))
            .addGroup(card_petugasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_iconPetugas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Available Product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(card_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(card_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 225, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card_stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card_petugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pallet.JPanelRounded card_petugas;
    private pallet.JPanelRounded card_stock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_iconPetugas;
    private javax.swing.JLabel lb_iconStock;
    private javax.swing.JLabel lb_jumlahAnggota;
    private javax.swing.JLabel lb_jumlahStock;
    private javax.swing.JLabel lb_petugas;
    private javax.swing.JLabel lb_stock;
    // End of variables declaration//GEN-END:variables
}
