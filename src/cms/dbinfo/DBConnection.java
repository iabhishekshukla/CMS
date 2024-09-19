package cms.dbinfo;
import java.sql.*;
public class DBConnection {

private static Connection con;
public static Connection createConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//factory method is used to create the object of the class
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms_db","root","root");
//		1. subprotocal 2. name os IP address of the machine where db has been installed
	}
	catch(ClassNotFoundException|SQLException cse){
		cse.printStackTrace();
		
	}
	return con;
}
////	public static void main(String[] args) {
////		Connection c = createConnection();
////		System.out.println(c);
//		
//	}
//	
	
}
