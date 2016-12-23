package hospital.business.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hospital.business.dept.Depart;
import hospital.business.doctor.Doctor;
import hospital.business.patient.Patient;
import hospital.db.DataBase;

public class Record {
	
	private int id;
	private Patient patient;
	private Doctor doctor;
	private Depart dept;
	private float fee;
	private String createTime;
	private String status;
	private static DataBase db;
	private static Connection con;
	private static PreparedStatement ps;
	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Depart getDept() {
		return dept;
	}

	public void setDept(Depart dept) {
		this.dept = dept;
	}
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Record record = new Record();
		Patient patient = new Patient();
		
		patient.name = "test2";
		record.setPatient(patient);
		//System.out.println(record.patient.name);
		Depart depart = new Depart();
		depart.setDeptName("¶ù¿Æ");
		record.setDept(depart);
		record.setCreateTime("2016-12-22 12:59:26");
		Record.insertRecord(record);
		//(new Record("2016-12-22 12:59:26")).insertRecord(record);
	}
	
	public static boolean insertRecord(Record record) {
		getCon();
		boolean flag = false;
		Patient patient = new Patient();
		Depart dept = new Depart();
		if(patient.insert(record.patient.name)) {
			String patid = patient.getId(record.patient.name);
			String deptid = dept.obtainId(record.dept.getDeptName());
			String createTime = record.createTime;
			try {
				ps = con.prepareStatement("insert into t_record(patientId,deptid,createTime,status) values(?,?,?,?)");
				ps.setString(1, patid);
				ps.setString(2, deptid);
				ps.setString(3, createTime);
				ps.setInt(4, 1);
				ps.execute();
				flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	  
	
	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}

}
