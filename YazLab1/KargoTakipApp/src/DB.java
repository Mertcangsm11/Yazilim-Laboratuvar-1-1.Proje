import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
public class DB {
     static Statement stat;
    static Connection conne;
    static String username="root";
    static String password="1234";
    static String DBurl="jdbc:mysql://34.69.234.59:3306/kargo";
    public Connection getConnection() throws SQLException{
        return(Connection) DriverManager.getConnection(DBurl, username, password);
    }
    public void ShowError(SQLException exception){
        System.out.println("Error:"+exception.getMessage());
        System.out.println("Error Code:"+exception.getErrorCode());
    }
    static ResultSet basla(){
    ResultSet rs = null;
    try{
        conne = (Connection) DriverManager.getConnection("jdbc:mysql://34.69.234.59/kargo","root","1234");
        stat = (Statement) conne.createStatement();
        rs = stat.executeQuery("select * from kargo.musteri");
    }catch(Exception e){
        e.printStackTrace();
    }
        return rs;
    }
    static ResultSet sorgulama(String mysql_sorgusu){
        ResultSet rs = null;
        try{
            rs = stat.executeQuery(mysql_sorgusu);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
