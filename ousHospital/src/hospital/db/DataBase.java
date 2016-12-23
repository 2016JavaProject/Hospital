package hospital.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase
{	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_hospital_jason";
	private String user = "root";
	private  String password = "root";
     
    
    
    public DataBase() {
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Connection getCon() {
		Connection con = null;
    	try {
			con = DriverManager.getConnection(url,user,password);
			System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return con;	
    }
    
    public void closeCon(Connection con) {
    	try {
				if(con != null)		con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    public static void main(String[] args) {
    	DataBase db = new DataBase();
    	Connection connnection = db.getCon();
    }
    
    
    
}