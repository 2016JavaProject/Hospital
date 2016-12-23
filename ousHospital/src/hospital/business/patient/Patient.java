package hospital.business.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import hospital.db.DataBase;

public class Patient {
	public  String id;
	public  String name;
	private static DataBase db;
	private static Connection con;
	private static PreparedStatement ps;
	
	public Patient(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Patient(String id) {
		super();
		this.name = this.getName(id);
	}
	
	
	
	public Patient() {
		super();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((new Patient()).getName(16));
		//castFee(15,666);
		/*if(Patient.insert((new Patient("78","test")))) {
			System.out.println("ye");
		}*/
		//System.out.println(Patient.getId("test"));
	}
	
	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}
	
	public boolean insert(String name) {
		getCon();
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into t_patient(name) values(?)");
			ps.setString(1, name);
			//ps.setString(2, name);
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public String getId(String name) {
		getCon();
		String id = null;
		String sql = "select * from t_patient where name=" +"'" +name +"'";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "√ª”–≤°»À");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public  String getName(String id) {
		getCon();
		String name = null;
		String sql = "select * from t_patient where id=" + id;
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;	
	}
	
	public  void castFee(int patientid, float fee) {
		getCon();
		String sql = "update t_record set Fee=" + fee + ", status=3" +" where patientId=" +patientid;
		System.out.println(sql);
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
