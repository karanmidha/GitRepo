package redbus.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {

	private static MyDBConnection instance=new MyDBConnection();
	
	 private MyDBConnection(){
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		 }
		 catch(ClassNotFoundException e){
			 e.printStackTrace();
		 }
	 }
	 
	 private Connection createConnection(){
		 Connection con=null;
		 try{
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sapient@123");
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		 return con;
	 }
	 
	 public static Connection getConnection(){
		 return instance.createConnection();
	 }
	
}
