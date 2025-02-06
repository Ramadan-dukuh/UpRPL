/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Daffa
 */
public class MenutView extends javax.swing.JFrame {
    
    private String username;

    int xx, xy;
    public MenutView(String username) {
        initComponents();
        this.username =username;
        lblWelcome.setText("Welcome "+ username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_kiri = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_DashboardMain = new javax.swing.JPanel();
        pn_DashboardLine = new javax.swing.JPanel();
        lb_iconDashboard = new javax.swing.JLabel();
        btn_Dashboard = new javax.swing.JLabel();
        pn_ProductMain = new javax.swing.JPanel();
        pn_ProductLine = new javax.swing.JPanel();
        lb_iconProduct = new javax.swing.JLabel();
        btn_Product = new javax.swing.JLabel();
        pn_kanan = new java.awt.Panel();
        pn_dasar = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();
        jPanelGradient1 = new pallet.JPanelGradient();
        lblWelcome = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        pn_kiri.setBackground(new java.awt.Color(255, 204, 204));
        pn_kiri.setPreferredSize(new java.awt.Dimension(300, 636));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_rpl_75px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel3.setText("Unit Produksi RPL");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Master Data");

        pn_DashboardMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_DashboardMainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_DashboardMainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_DashboardMainMouseExited(evt);
            }
        });

        pn_DashboardLine.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pn_DashboardLineLayout = new javax.swing.GroupLayout(pn_DashboardLine);
        pn_DashboardLine.setLayout(pn_DashboardLineLayout);
        pn_DashboardLineLayout.setHorizontalGroup(
            pn_DashboardLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pn_DashboardLineLayout.setVerticalGroup(
            pn_DashboardLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lb_iconDashboard.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        lb_iconDashboard.setForeground(new java.awt.Color(153, 153, 153));
        lb_iconDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icDashboard.png"))); // NOI18N

        btn_Dashboard.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_Dashboard.setForeground(new java.awt.Color(51, 51, 51));
        btn_Dashboard.setText("Dashboard");

        javax.swing.GroupLayout pn_DashboardMainLayout = new javax.swing.GroupLayout(pn_DashboardMain);
        pn_DashboardMain.setLayout(pn_DashboardMainLayout);
        pn_DashboardMainLayout.setHorizontalGroup(
            pn_DashboardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DashboardMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pn_DashboardLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        pn_DashboardMainLayout.setVerticalGroup(
            pn_DashboardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DashboardMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pn_DashboardLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(pn_DashboardMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_DashboardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_iconDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_DashboardMainLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_Dashboard)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pn_ProductMain.setPreferredSize(new java.awt.Dimension(228, 60));
        pn_ProductMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_ProductMainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_ProductMainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_ProductMainMouseExited(evt);
            }
        });

        pn_ProductLine.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pn_ProductLineLayout = new javax.swing.GroupLayout(pn_ProductLine);
        pn_ProductLine.setLayout(pn_ProductLineLayout);
        pn_ProductLineLayout.setHorizontalGroup(
            pn_ProductLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pn_ProductLineLayout.setVerticalGroup(
            pn_ProductLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lb_iconProduct.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        lb_iconProduct.setForeground(new java.awt.Color(153, 153, 153));
        lb_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icProduct-transformed.png"))); // NOI18N

        btn_Product.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_Product.setForeground(new java.awt.Color(51, 51, 51));
        btn_Product.setText("Product");

        javax.swing.GroupLayout pn_ProductMainLayout = new javax.swing.GroupLayout(pn_ProductMain);
        pn_ProductMain.setLayout(pn_ProductMainLayout);
        pn_ProductMainLayout.setHorizontalGroup(
            pn_ProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ProductMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pn_ProductLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_iconProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Product)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ProductMainLayout.setVerticalGroup(
            pn_ProductMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ProductMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pn_ProductLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(pn_ProductMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_iconProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_ProductMainLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_Product)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_kiriLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_kiriLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(pn_DashboardMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_ProductMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_kiriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_DashboardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_ProductMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(628, Short.MAX_VALUE))
        );

        getContentPane().add(pn_kiri, java.awt.BorderLayout.LINE_START);

        pn_kanan.setLayout(new java.awt.BorderLayout());

        pn_utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_utama.setLayout(new java.awt.BorderLayout());

        jPanelGradient1.setColorEnd(new java.awt.Color(51, 255, 255));
        jPanelGradient1.setColorStart(new java.awt.Color(0, 0, 255));

        lblWelcome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("jLabel4");

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        Logout.setContentAreaFilled(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 877, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(Logout))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(jPanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pn_kanan.add(pn_dasar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pn_kanan, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void pn_DashboardMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_DashboardMainMouseClicked
        pn_DashboardMain.setBackground(new Color(240, 240, 240));
        pn_DashboardLine.setBackground(new Color(255, 255, 255));

        pn_utama.removeAll();
        pn_utama.add(new MenuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_pn_DashboardMainMouseClicked

    private void pn_DashboardMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_DashboardMainMouseEntered
        pn_DashboardMain.setBackground(new Color(255, 255, 255));
        pn_DashboardLine.setBackground(new Color(0, 255, 255));
    }//GEN-LAST:event_pn_DashboardMainMouseEntered

    private void pn_DashboardMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_DashboardMainMouseExited
        pn_DashboardMain.setBackground(new Color(240, 240, 240));
        pn_DashboardLine.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_pn_DashboardMainMouseExited

    private void pn_ProductMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ProductMainMouseClicked
        pn_ProductMain.setBackground(new Color(240, 240, 240));
        pn_ProductLine.setBackground(new Color(255, 255, 255));

        pn_utama.removeAll();
        pn_utama.add(new MenuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_pn_ProductMainMouseClicked

    private void pn_ProductMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ProductMainMouseEntered
        pn_ProductMain.setBackground(new Color(255, 255, 255));
        pn_ProductLine.setBackground(new Color(0, 255, 255));
    }//GEN-LAST:event_pn_ProductMainMouseEntered

    private void pn_ProductMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ProductMainMouseExited
        pn_ProductMain.setBackground(new Color(240, 240, 240));
        pn_ProductLine.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_pn_ProductMainMouseExited

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
    
        if (confirm == JOptionPane.YES_OPTION) {
            // Menutup frame utama yang berisi panel ini
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutActionPerformed

    /**
     * @param args the command line arguments
     */
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
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenutView().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel btn_Dashboard;
    private javax.swing.JLabel btn_Product;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private pallet.JPanelGradient jPanelGradient1;
    private javax.swing.JLabel lb_iconDashboard;
    private javax.swing.JLabel lb_iconProduct;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pn_DashboardLine;
    private javax.swing.JPanel pn_DashboardMain;
    private javax.swing.JPanel pn_ProductLine;
    private javax.swing.JPanel pn_ProductMain;
    private javax.swing.JPanel pn_dasar;
    private java.awt.Panel pn_kanan;
    private java.awt.Panel pn_kiri;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
