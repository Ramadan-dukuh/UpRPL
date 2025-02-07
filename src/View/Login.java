/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.LoginDao;
import javax.swing.JOptionPane;
import model.Petugas;

/**
 *
 * @author Hp
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_putih = new javax.swing.JPanel();
        pn_biruKiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn_abuKanan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        itemPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        pn_putih.setBackground(new java.awt.Color(255, 255, 255));
        pn_putih.setPreferredSize(new java.awt.Dimension(800, 500));
        pn_putih.setLayout(null);

        pn_biruKiri.setBackground(new java.awt.Color(0, 0, 255));
        pn_biruKiri.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo rplhd.png"))); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("copyright © Unit Produksi RPL All rights reserved");

        javax.swing.GroupLayout pn_biruKiriLayout = new javax.swing.GroupLayout(pn_biruKiri);
        pn_biruKiri.setLayout(pn_biruKiriLayout);
        pn_biruKiriLayout.setHorizontalGroup(
            pn_biruKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_biruKiriLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pn_biruKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pn_biruKiriLayout.setVerticalGroup(
            pn_biruKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_biruKiriLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pn_putih.add(pn_biruKiri);
        pn_biruKiri.setBounds(0, 0, 400, 500);

        pn_abuKanan.setBackground(new java.awt.Color(230, 230, 230));
        pn_abuKanan.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("User");

        itemUser.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        itemUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUserActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Password");

        itemPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPassActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(0, 0, 204));
        btnLogin.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Doesn't have an account?");

        btnSignup.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(0, 0, 255));
        btnSignup.setText("Sign Up");
        btnSignup.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSignup.setContentAreaFilled(false);
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_abuKananLayout = new javax.swing.GroupLayout(pn_abuKanan);
        pn_abuKanan.setLayout(pn_abuKananLayout);
        pn_abuKananLayout.setHorizontalGroup(
            pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_abuKananLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_abuKananLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSignup))
                    .addComponent(jLabel4)
                    .addGroup(pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_abuKananLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(121, 121, 121))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_abuKananLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(328, 328, 328)))
                    .addGroup(pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(itemPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(itemUser, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pn_abuKananLayout.setVerticalGroup(
            pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_abuKananLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_abuKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pn_putih.add(pn_abuKanan);
        pn_abuKanan.setBounds(400, 0, 400, 502);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pn_putih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pn_putih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemUserActionPerformed

    private void itemPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPassActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
   // Mendapatkan input dari text field
    String username = itemUser.getText().trim();
    String password = new String(itemPass.getPassword()).trim();

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username atau Password tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    LoginDao loginDao = new LoginDao();
    Petugas petugas = loginDao.getPetugas(username);

    if (petugas != null && petugas.getPassword().equals(password)) {
//        JOptionPane.showMessageDialog(this, "Login Berhasil!\nUsername: " + petugas.getUsername() + "\nKelas: " + petugas.getKelas(), "Sukses", JOptionPane.INFORMATION_MESSAGE);

        // Kirim username dan kelas ke halaman berikutnya (contoh: MenutView)
        MenutView menu = new MenutView(petugas.getUsername(), petugas.getKelas());
        menu.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        // Mendapatkan input dari text field
         String username = itemUser.getText().trim();
    String password = new String(itemPass.getPassword()).trim();

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username atau Password tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    LoginDao loginDao = new LoginDao();
    Petugas petugas = loginDao.getPetugas(username);

    if (petugas != null && petugas.getPassword().equals(password)) {
//        JOptionPane.showMessageDialog(this, "Login Berhasil!\nUsername: " + petugas.getUsername() + "\nKelas: " + petugas.getKelas(), "Sukses", JOptionPane.INFORMATION_MESSAGE);

        // Kirim username dan kelas ke halaman berikutnya (contoh: MenutView)
        MenutView menu = new MenutView(petugas.getUsername(), petugas.getKelas());
        menu.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLoginMouseClicked

    /**
     * @param args the command line arguments
     */
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JPasswordField itemPass;
    private javax.swing.JTextField itemUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pn_abuKanan;
    private javax.swing.JPanel pn_biruKiri;
    private javax.swing.JPanel pn_putih;
    // End of variables declaration//GEN-END:variables
}
