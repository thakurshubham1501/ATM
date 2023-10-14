package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public  class InsertCustomerrecord {

	public static void insertrecord(int amount,int Account) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","2001");
			Statement stmt=con.createStatement();
			if(Account==0) {
			stmt.executeUpdate("INSERT INTO Trans (Amount,Date) VALUES ('"+amount+"',CURRENT_TIMESTAMP)");
			}else{
			stmt.executeUpdate("UPDATE Trans  SET amount='"+amount+"', Date=CURRENT_TIMESTAMP WHERE ID='"+Account+"'");
			}con.close();
			}catch(Exception e){ System.out.println(e);}	
	}
}
