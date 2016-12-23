package hospital.business.outpatient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hospital.business.medicine.Medicine;
import hospital.business.medicine.Prescription;
import hospital.business.patient.Patient;
import hospital.db.DataBase;

public class OutpatientSystem {
	private static DataBase db;
	private static Connection con;
	private static PreparedStatement ps;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int fee = OutpatientSystem.feeObtain("齐");
		//System.out.println(fee);
		
		/*if(OutpatientSystem.feeToll(16)) {
			System.out.println("ye");
		} else {
			System.out.println("no");
		}*/
		/*List<Prescription> values = OutpatientSystem.mediList(12);
		System.out.println("ye");*/
	}
	
	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}
	
	public int feeObtain(String patientName) {
		getCon();
		int fee = 0;
		Patient patient = new Patient();
		String patientid = patient.getId(patientName);
		System.out.println(patientid);
		try {
			ps = con.prepareStatement("select Fee from t_record where patientId=? and status=3");
			ps.setString(1, patientid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				fee = rs.getInt("Fee");
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "病人没有产生费用");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return fee;
	}
	
	public boolean feeToll(int patientid) {
		getCon();
		boolean flag = false;
		try {
			ps = con.prepareStatement("update t_record set status=0 where patientId=? and status=3");
			ps.setInt(1, patientid);
			con.setAutoCommit(false);
			ps.executeUpdate();
			con.commit();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//Prescription
	public List<Prescription> mediList(int patientid){
		getCon();
		List<Prescription> values = new ArrayList<Prescription>();
		try {
			ps = con.prepareStatement("select * from t_prescription where patientid=?");
			ps.setInt(1, patientid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Prescription pres = new Prescription();
				Medicine medi = new Medicine();
				int medicineid = rs.getInt("medicineid");
				int medicineNum = rs.getInt("num");
				String mediName = medi.nameObtain(medicineid);
				pres.setMediName(mediName);
				pres.setNum(medicineNum);
				values.add(pres);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

}
