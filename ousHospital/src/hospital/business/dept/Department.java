package hospital.business.dept;

import java.util.List;

public abstract class Department {
	public int id;
	public String name;
	
	
	public Department(int id) {
		super();
		this.id = id;
		//this.name = name;
	}
	
	public Department() {
		
	}
	//abstract List<String[]> dataList();
	
	//ͨ��ID��ȡName
	public abstract String getName(int id);
	
	//��ȡ����ʼ��combobx�����ݡ�
	abstract String[] getComItem();
	
	//�����combobox������ƥ���index
	abstract int getComIndex(String item);
	
	//��÷���combobox�������������index
	abstract int listIndex(String item); 
}


