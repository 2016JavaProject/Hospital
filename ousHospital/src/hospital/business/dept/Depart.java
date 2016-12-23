package hospital.business.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.db.DataBase;

public class Depart extends Department {
	private int deptid;
	private String deptName;
	private int patientNum;
	private int deptIncome;
	private static PreparedStatement ps;
	private static Connection connection;
	//private static ResultSet rs ;
	//private static Department depart;
	//private DataBase db;
	
	
	
	public Depart(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.id = id;
		name = getName(id);
	}
	
	/*//包含部门名称，部门看病人数，部门收入的构造函数
	public Depart(String deptName, int patientNum, int deptIncome) {
		this.deptName = deptName;
		this.patientNum = patientNum;
		this.deptIncome = deptIncome;
	}*/
	

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}	
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getPatientNum() {
		return patientNum;
	}

	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}

	

	public int getDeptIncome() {
		return deptIncome;
	}

	public void setDeptIncome(int deptIncome) {
		this.deptIncome = deptIncome;
	}

	public Depart() {
		
	}
	
	//查看部门的一天看病人数和部门收入
	public List<Depart> getIncome() {
		getCon();
		List<Depart> values = new ArrayList<Depart>();
		//String sql = "select * from t_record where ";
		for(int i=0; i < Depart.dataList().size(); i++) {
			String deptid = Depart.dataList().get(i)[0];
			String daptname = Depart.dataList().get(i)[1];
			try {
				ps = connection.prepareStatement("select count(patientid),sum(Fee) from t_record where deptid=? and status = 0 and createTime>=date(now()) and createTime<DATE_ADD(date(now()),INTERVAL 1 DAY)");
				ps.setString(1, deptid);
				ResultSet rs = ps.executeQuery();
				/*while(rs.next()) {
					Depart depart = new Depart();
					depart.deptName = Depart.dataList().get(i)[1];
					depart.
					System.out.println(1);
				}*/
				//System.out.print(Depart.dataList().get(i)[0]);
				//System.out.print(Depart.dataList().get(i)[1]);
				//rs.last();
				while(rs.next()) {
					if(!rs.getString(1).equals("0")){
						Depart depart = new Depart();
						depart.deptName = daptname;
						depart.patientNum = Integer.parseInt(rs.getString(1));
						depart.deptIncome = Integer.parseInt(rs.getString(2));
						values.add(depart);
					}
				}
				System.out.println("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return values;
	}
	
	public static List<String[]> dataList() {
		// TODO Auto-generated method stub
		//getCon();
		String sql = "select * from t_dept";
		List<String[]> values = new ArrayList<String[]>();
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				String[] data = new String[2];
				data[0] = rs.getInt(1) + "";
				//data[0] = rs.getString(id);
				data[1] = rs.getString(2);
				values.add(data);
			}
			if(!flag) {
				System.out.println("查询结果为空");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for(int i = 0; i<values.size(); i++) {
			System.out.println(values.get(i)[1]);
		}*/
		return values;
	}
	
	public String getName(int id) {
		// TODO Auto-generated method stub
		getCon();
		//Depart depart = new Depart(id);
		List<String[]> list = dataList();
		for(int i = 0; i<list.size(); i++) {
			if(id == Integer.parseInt((list.get(i)[0]))) {
				name = list.get(i)[1];
			}
		}
		return name;
		
	}
	
	public String obtainId(String name){
		String id=null;
		getCon();
		List<String[]> list = dataList();
		for(int i = 0; i<list.size(); i++) {
			if(name.equals(list.get(i)[1])) {
				id = list.get(i)[0];
			}
		}
		return id;
	}
	
	
	 public String[] getComItem() {
		getCon();
		List<String[]> list = dataList();
		String[] combox = new String[list.size()];
		//HashMap<Integer,String> comBox = new HashMap
		for(int i = 0; i < list.size(); i++) {
			combox[i] = list.get(i)[1];
		}
		return combox;
	}
	
	 
	public int getComIndex(String item) {
		//item = "妇科";
		getCon();
		//int j = 0;
		List<String[]> list = dataList();
		for(int i = 0; i < list.size(); i++) {
			if(item.equals(list.get(i)[1])) {
				id = Integer.parseInt(list.get(i)[0]);
				//id = i;
			}
		}
		return id;
	}
	
	public int listIndex(String item) {
		getCon();
		List<String[]> list = dataList();
		for(int i = 0; i < list.size(); i++) {
			if(item.equals(list.get(i)[1])) {
				//id = Integer.parseInt(list.get(i)[0]);
				id = i;
			}
		}
		return id;
	}
	
	//连通数据库
	public static void getCon() {
		DataBase db = new DataBase();
		connection = db.getCon();
	}
	
	
	public static void main(String[] args) {
		List<Depart> values = (new Depart()).getIncome();
		System.out.println("ye");
	}

	

}
