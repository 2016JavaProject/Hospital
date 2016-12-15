package Test;

import java.util.ArrayList;
import java.util.List;

import business.entity.patient.PatientEntity;
import business.service.patient.PatientService;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<PatientEntity> array = new ArrayList();
		PatientEntity t = new PatientEntity(); 
		PatientService patientservice = new PatientService();
		array = patientservice.ListAll();
		for(int i=0;i<array.size();i++){
			System.out.println(array.get(i).getId()+array.get(i).getName());
		}
//		t.setAge(20);
//		t.setComm("ºÇºÇnima");

//		t.setTel("811");	
//		t.setName("Ãû×Ö");
	}
}
