package Test;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet re = null;
		String url = "jdbc:mysql://localhost:3306/cecjsyy";
		String user = "root";
		String password = "root";
		String sql = "select * from t_cec_part";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("成功加载MySQL驱动程序");
		try {
			conn = DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			re = stmt.executeQuery(sql);
			while(re.next()){
				String id = re.getString("id");
				String partname = re.getString("partname");
				String description = re.getString("description");
				String comment = re.getString("comment");
				System.out.println(id+","+partname+","+description+","+comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			re.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
