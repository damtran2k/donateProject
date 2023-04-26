package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//Ket noi voi database
		
		String url ="jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+dbName;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			System.out.println("can't connnect");
			e.printStackTrace();
		}
		try {
			if(instance== null || instance.trim().isEmpty()) 
				url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName+";encrypt=false;";
		
		} catch (Exception e) {
			System.out.println("cant connect to database1");
			e.printStackTrace();
		}
			return DriverManager.getConnection(url,"sa","12345");
	}	
	private final String serverName ="localhost";
	private final String dbName ="DonationFund";
	private final String portNumber ="1433";
	private final String instance ="";
	private final String userID ="sa";
	private final String password ="12345";

}
