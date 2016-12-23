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
	
	//通过ID获取Name
	public abstract String getName(int id);
	
	//获取“初始化combobx的内容”
	abstract String[] getComItem();
	
	//获得与combobox的内容匹配的index
	abstract int getComIndex(String item);
	
	//获得放入combobox数组对象的数组的index
	abstract int listIndex(String item); 
}


