package business.service.patient;
import business.entity.patient.PatientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.MySQLHelper;

public class PatientService {
	public void AddPatientDao(PatientEntity patientEntity){
		String sql = "INSERT INTO t_patient(id, name, tel, age, comm) VALUES(?,?,?,?,?)";
		String[] parameters = {patientEntity.getId(),patientEntity.getName(),patientEntity.getTel(),Integer.toString(patientEntity.getAge()),patientEntity.getComm()};
		MySQLHelper.executeUpdate(sql, parameters);
	}
	
	public void DelPatientDao (String id) {
		String sql = "delete from t_patient WHERE id = ?";
		String[] parameters = {id};
		MySQLHelper.executeUpdate(sql, parameters);
	}
	
	public void DelPatientDao (PatientEntity patientEntity) {
		String sql = "UPDATE t_patient SET isEnabled = 0 WHERE id = ?";
		String[] parameters = {patientEntity.getId()};
		MySQLHelper.executeQuery(sql, parameters);
	}
	
	public void UpdatePatientDao (PatientEntity patientEntity) {
		String sql = "UPDATE t_patient SET name = ?, tel = ?, age = ?, comm = ? WHERE id = ?";
		String[] parameters = {patientEntity.getName(),patientEntity.getTel(),Integer.toString(patientEntity.getAge()),patientEntity.getComm(),patientEntity.getId()};
		MySQLHelper.executeUpdate(sql, parameters);
	}
	
	public PatientEntity FindPatientDao1 (String id) {
		String sql = "SELECT * FROM t_patient WHERE ID = ? ";
		String[] parameters = {id};
		ResultSet rs = MySQLHelper.executeQuery(sql, parameters);
		PatientEntity patientEntity = new PatientEntity();
		try {
			if(rs.next()){
				patientEntity.setId(rs.getString("id"));
				patientEntity.setName(rs.getString("name"));
				patientEntity.setTel(rs.getString("tel"));
				patientEntity.setAge(rs.getInt("age"));
				patientEntity.setComm(rs.getString("comm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientEntity;

	}
	
	public ArrayList<PatientEntity> ListAll () {
		String sql = "SELECT * FROM t_patient where 1 = 1";
		ResultSet rs = MySQLHelper.executeQuery(sql, null);
		ArrayList<PatientEntity> list = new ArrayList<>();
		try {
			while(rs.next()) {
				PatientEntity patientEntity = new PatientEntity();
				patientEntity.setId(rs.getString("id"));
				patientEntity.setName(rs.getString("name"));
				patientEntity.setTel(rs.getString("tel"));
				patientEntity.setAge(rs.getInt("age"));				
				patientEntity.setComm(rs.getString("comm"));				
				list.add(patientEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
