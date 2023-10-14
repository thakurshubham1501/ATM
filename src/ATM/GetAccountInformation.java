package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAccountInformation {
static boolean getInformation(int account) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","2001");
			Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Trans where id='"+account+"' "); 
            while (rs.next()) {
               if(rs.getInt("id")==account);
               return true;
            }
            return false;
			}catch(Exception e){ System.out.println(e);
			return false;
			}
           
           	
}
}
