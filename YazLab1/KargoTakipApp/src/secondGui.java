
import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
//import com.mysql.jdbc.Connection;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.dom.By;
import com.teamdev.jxbrowser.chromium.dom.DOMDocument;
import com.teamdev.jxbrowser.chromium.dom.DOMElement;
import com.teamdev.jxbrowser.chromium.dom.DOMInputElement;
import com.teamdev.jxbrowser.chromium.events.ConsoleEvent;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.deps.org.checkerframework.common.returnsreceiver.qual.This;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.TokenType;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sİnan
 */
public class secondGui extends javax.swing.JFrame {

    static int a;
    
     static ArrayList<Double> adlist = new ArrayList<>();
     static ArrayList<Double> adlist2 = new ArrayList<>();
     static ArrayList<String> adlist3 = new ArrayList<>();
     public void deneme() {
        
        
        try {

            Connection conn = null;

            Statement st = null;

            ResultSet rs = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String dbUrl = "jdbc:mysql://34.69.234.59:3306/kargo";

             conn = DriverManager.getConnection(dbUrl, "root", "1234");

            st = conn.createStatement();

            rs = st.executeQuery("SELECT musterilokasyonx FROM kargo.musteri where musteriteslimatdurumu='Teslim Edilmedi'");
            
            

            while(rs.next()){

               adlist.add(rs.getDouble("musterilokasyonx"));

            }
            
            
                } catch (InstantiationException ex) {

                  System.out.println(ex.getMessage());

                } catch (SQLException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   public void deneme2() {
        
        
        try {

            Connection conn = null;

            Statement st = null;
            
            ResultSet rs2 = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String dbUrl = "jdbc:mysql://34.69.234.59:3306/kargo";

             conn = DriverManager.getConnection(dbUrl, "root", "1234");

            st = conn.createStatement();

            rs2 = st.executeQuery("SELECT musterilokasyony FROM kargo.musteri where musteriteslimatdurumu='Teslim Edilmedi'");
            
            

            while(rs2.next()){

               adlist2.add(rs2.getDouble("musterilokasyony"));

            }
            
            
                } catch (InstantiationException ex) {

                  System.out.println(ex.getMessage());

                } catch (SQLException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   public void deneme3(){
        try {

            Connection conn = null;

            Statement st = null;

            ResultSet rs3 = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String dbUrl = "jdbc:mysql://34.69.234.59:3306/kargo";

            conn = DriverManager.getConnection(dbUrl, "root", "1234");

            st = conn.createStatement();

            rs3 = st.executeQuery("SELECT musteriadi FROM kargo.musteri where musteriteslimatdurumu='Teslim Edilmedi' ");

            

            while(rs3.next()){

               adlist3.add(rs3.getString("musteriadi"));

            }


                } catch (InstantiationException ex) {

                  System.out.println(ex.getMessage());

                } catch (SQLException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     static List initialCities = new ArrayList<city>();
    public secondGui() {
        initComponents();
        deneme();
        deneme2(); 
        deneme3(); 
        open_site();
        TabloDoldur();
        Isaretle();        
       
    }
    
        
        public void TabloDoldur(){
     
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            
            connect = db.getConnection();
            String sql="select * from kargo.musteri where musteriteslimatdurumu='Teslim Edilmedi'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             gizliTablo.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(deneme2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        public void Isaretle(){
            TabloDoldur();
            Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT COUNT(idmusteri) FROM kargo.musteri where musteriteslimatdurumu='Teslim Edilmedi'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             while(rs.next()) {
            a= rs.getInt("COUNT(idmusteri)");
            System.out.println(a);
            
         }
             
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(secondGui.class.getName()).log(Level.SEVERE, null, ex);
        }
            DOMDocument dosya = browser.getDocument();
         DOMElement lokasyon = dosya.findElement(By.id("address"));
         DOMElement arama = dosya.findElement(By.id("submit"));
         DOMInputElement butonumuz = (DOMInputElement) arama;
         DOMInputElement konum = (DOMInputElement) lokasyon;
            for (int i = 0; i < a; i++) {
                TabloDoldur();
                konum.setValue(gizliTablo.getValueAt(i,3)+","+gizliTablo.getValueAt(i, 4));
                butonumuz.click(); 
                
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

        mapPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gizliTablo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        yazi = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mapPanel.setLayout(new java.awt.BorderLayout());
        mapPanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(mapPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 700));

        jPanel1.setLayout(new java.awt.BorderLayout());

        gizliTablo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(gizliTablo);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 390));

        yazi.setBackground(new java.awt.Color(223, 112, 30));
        yazi.setColumns(20);
        yazi.setRows(5);
        yazi.setPreferredSize(null);
        jScrollPane2.setViewportView(yazi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 0, 500, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(secondGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(secondGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(secondGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(secondGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               
            }
        });
    }
    
    public void printShortestRoute(Route shortestRoute){
        System.out.println("------------------------------------------------------------------");
        System.out.println("En kısa yol: "+ shortestRoute);
        System.out.println("w/ total distance: "+ shortestRoute.calculateTotalDistance());
        System.out.println("------------------------------------------------------------------"); 
        yazi.setText("\n--------------------------------------------------------------------------------------\n"+
                "En kısa yol: "+shortestRoute+"\nRota Toplam: "+ shortestRoute.calculateTotalDistance()+
                "\n--------------------------------------------------------------------------------------\n");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gizliTablo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JTextArea yazi;
    // End of variables declaration//GEN-END:variables
     Browser browser;
    BrowserView view;

    public void open_site() {
        BrowserUtil.setVersion(Version.V6_22);

        browser = new Browser();
        view = new BrowserView(browser);

        mapPanel.add(view, BorderLayout.CENTER);
        
         browser.addTitleListener((TitleEvent evt) -> {
            jLabel1.setText("   " + evt.getTitle());
        });

        browser.addConsoleListener((ConsoleEvent evt) -> {
            System.out.println("LOG: " + evt.getMessage());
        });

        browser.addLoadListener(new LoadAdapter() {
            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent evt) {
                evt.getBrowser().setZoomLevel(-1);
            }
        });

        browser.loadURL("C:\\Users\\Sİnan\\Desktop\\deneme\\web geliştirme\\uygulama\\kargoharita.html");
    }
    

        
        
                
    
}
