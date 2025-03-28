package newproject;
import java.sql.*;

public class DBLoader {
    public static ResultSet executeSQL(String sql) 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
//            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.59.18:3306/project", "vmm", "Saksham@123");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/POS", "root", "Saksham@123");
            System.out.println("Connection done");
            
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement done");
            
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ResultSet Created");   
            
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
