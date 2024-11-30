/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Database.Config;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class B_Login extends javax.swing.JFrame {

    /**
     * Creates new form B_Login
     */
    public B_Login() {
        initComponents();
        
        lbl_bg.setIcon(new FlatSVGIcon("Resource_Login/BG_Login.svg", 1000, 563));
        CekPw.setIcon(new FlatSVGIcon("Resource_Login/ShowPw.svg", 31, 31));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usnm = new javax.swing.JTextField();
        CekPw = new javax.swing.JCheckBox();
        txt_pw = new javax.swing.JPasswordField();
        buttonDesign1 = new Costum.ButtonDesign();
        lbl_eror = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();
        lbl_layer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usnm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_usnm.setForeground(new java.awt.Color(17, 137, 163));
        txt_usnm.setBorder(null);
        getContentPane().add(txt_usnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 213, 250, 30));

        CekPw.setRolloverEnabled(false);
        CekPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CekPwActionPerformed(evt);
            }
        });
        getContentPane().add(CekPw, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 293, 30, 30));

        txt_pw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_pw.setForeground(new java.awt.Color(17, 137, 163));
        txt_pw.setBorder(null);
        getContentPane().add(txt_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 293, 210, 30));

        buttonDesign1.setText("Masuk");
        buttonDesign1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonDesign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesign1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDesign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 355, 298, 40));

        lbl_eror.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbl_eror.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lbl_eror, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 334, 210, 20));

        lbl_bg.setText("lbl_bg");
        getContentPane().add(lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 563));

        lbl_layer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource_Login/L_Login.png"))); // NOI18N
        getContentPane().add(lbl_layer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 563));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDesign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesign1ActionPerformed
        // TODO add your handling code here:
        String username = txt_usnm.getText();
        String password = new String(txt_pw.getPassword());

        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT role FROM users WHERE username = ? AND password = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                if ("admin".equalsIgnoreCase(role)) {
                    C_AdminPage adminPage = new C_AdminPage();
                    adminPage.setVisible(true);
                    this.dispose();
                } else if ("dokter".equalsIgnoreCase(role)) {
                    C_AdminPage userPage = new C_AdminPage();
                    userPage.setVisible(true);
                    this.dispose();
                }
            } else {
            // Menampilkan pesan error jika login gagal
            lbl_eror.setText("*Username atau password salah!");
        }

    } catch (SQLException e) {
        // Menampilkan pesan error jika terjadi kesalahan pada database
        lbl_eror.setText("Terjadi kesalahan pada database!");
        e.printStackTrace();
    }
    }//GEN-LAST:event_buttonDesign1ActionPerformed

    private void CekPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CekPwActionPerformed
        // TODO add your handling code here:
        // Mengecek apakah checkbox CekPw dicentang atau tidak
    if (CekPw.isSelected()) {
        // Jika dicentang, tampilkan password dalam bentuk teks
        txt_pw.setEchoChar((char) 0);  // Menghilangkan karakter pengganti password
        // Ganti ikon dengan ikon "HidePw"
        CekPw.setIcon(new FlatSVGIcon("Resource_Login/HidePw.svg", 31, 31));
    } else {
        // Jika tidak dicentang, sembunyikan password dengan karakter default
        txt_pw.setEchoChar('*');  // Menggunakan '*' sebagai pengganti karakter password
        // Ganti ikon dengan ikon "ShowPw"
        CekPw.setIcon(new FlatSVGIcon("Resource_Login/ShowPw.svg", 31, 31));
    }

   
    }//GEN-LAST:event_CekPwActionPerformed

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
            java.util.logging.Logger.getLogger(B_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(B_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(B_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(B_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new B_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CekPw;
    private Costum.ButtonDesign buttonDesign1;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_eror;
    private javax.swing.JLabel lbl_layer;
    private javax.swing.JPasswordField txt_pw;
    private javax.swing.JTextField txt_usnm;
    // End of variables declaration//GEN-END:variables
}