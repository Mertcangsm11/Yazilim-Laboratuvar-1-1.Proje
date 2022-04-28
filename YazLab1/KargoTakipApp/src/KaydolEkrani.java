
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sİnan
 */
public class KaydolEkrani extends javax.swing.JFrame {

    /**
     * Creates new form KaydolEkrani
     */
    public KaydolEkrani() {
        initComponents();
    }
        public void  Insert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into kargo.musteri (musteriadi,musterisifre,musterilokasyonx,musterilokasyony,musteriteslimatdurumu)"
                 +"values(?,?,?,?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, kullaniciAdi_text.getText());
         statement.setString(2, sifre_text.getText());
         statement.setString(3, "0");
         statement.setString(4, "0");
         statement.setString(5, "Kargo Yok");
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null,"Kayıt Başarıyla Eklendi");
         }catch(SQLException exception){
             db.ShowError(exception);
         }finally{
             statement.close();
             connect.close();
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

        kaydolbutonu = new javax.swing.JButton();
        kullaniciAdi_text = new javax.swing.JTextField();
        sifre_text = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        kaydolbutonu.setBackground(new java.awt.Color(0, 153, 51));
        kaydolbutonu.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        kaydolbutonu.setText("KAYIT OL");
        kaydolbutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydolbutonuActionPerformed(evt);
            }
        });
        getContentPane().add(kaydolbutonu);
        kaydolbutonu.setBounds(130, 270, 310, 50);

        kullaniciAdi_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciAdi_textActionPerformed(evt);
            }
        });
        getContentPane().add(kullaniciAdi_text);
        kullaniciAdi_text.setBounds(150, 100, 320, 22);

        sifre_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifre_textActionPerformed(evt);
            }
        });
        getContentPane().add(sifre_text);
        sifre_text.setBounds(150, 150, 320, 22);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel9.setText("SIFRE:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 160, 90, 20);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel7.setText("KULLANICI ADI:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 100, 80, 20);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ÜYE KAYIT FORMU");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 30, 190, 50);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 600);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/3.jpeg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(167, 318, 400, 280);

        jPanel1.setBackground(new java.awt.Color(223, 112, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 570, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kullaniciAdi_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciAdi_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kullaniciAdi_textActionPerformed

    private void sifre_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifre_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sifre_textActionPerformed

    private void kaydolbutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydolbutonuActionPerformed
            try {
            Insert();
            GirisEkrani1 menu=new GirisEkrani1();
            menu.setSize(570,600);
            menu.setVisible(true);
                setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(KaydolEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kaydolbutonuActionPerformed

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
            java.util.logging.Logger.getLogger(KaydolEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KaydolEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KaydolEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KaydolEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KaydolEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kaydolbutonu;
    private javax.swing.JTextField kullaniciAdi_text;
    private javax.swing.JTextField sifre_text;
    // End of variables declaration//GEN-END:variables
}