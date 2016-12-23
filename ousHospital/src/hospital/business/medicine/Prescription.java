package hospital.business.medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.db.DataBase;

public class Prescription {
	
	private int id;
	private int patientid;
	private int medcineid;
	private String mediName;
	private int num;
	//private int price;
	private static DataBase db;
	private static Connection con;
	private static PreparedStatement ps;
	

	public String getMediName() {
		return mediName;
	}

	public void setMediName(String mediName) {
		this.mediName = mediName;
	}
	
	public int getMedcineid() {
		return medcineid;
	}
	
	public void setMedcineid(int medcineid) {
		this.medcineid = medcineid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Prescription( int patientid, int medcineid, int num) {
		super();
		//this.id = id;
		this.patientid = patientid;
		this.medcineid = medcineid;
		this.num = num;
	}

	public Prescription() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*List<Prescription> values = new ArrayList<Prescription>();
		
		values.add(new Prescription(1,1,1));
		values.add(new Prescription(2,2,2));
		values.add(new Prescription(3,3,3));
		storeList(values);*/
		Prescription.delete(87);
	}
	
	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}
	
	public void storeList(List<Prescription> list) {
		getCon();
		for(Prescription pre : list) {
			try {
				ps = con.prepareStatement("insert into t_prescription(patientid,medicineid,num) values (?, ?, ?) ");
				//ps.setInt(1, pre.id);
				ps.setInt(1, pre.patientid);
				ps.setInt(2, pre.medcineid);
				ps.setInt(3, pre.num);
				ps.execute();
				//con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static  boolean delete(int patientid) {
		getCon();
		boolean result = false;
		String sql = "delete from t_prescription where patientid=" + patientid ;
		System.out.println(sql);
		try {
			ps =con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.execute();
			result = true;
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("删除时出现了错误");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("删除时出现了错误");
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} 
	

}
