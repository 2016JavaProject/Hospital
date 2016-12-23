package hospital.business.apothecary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hospital.db.DataBase;

public class Apothecary {
	
	private int id;
	private String name;
	private String password;
	private static DataBase db;
	private static Connection con;
	private static PreparedStatement ps;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Apothecary() {
		super();
	}

	public Apothecary(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Apothecary [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Apothecary apot = new Apothecary();
		//apot.getInfo(apot, 1);
		//apot.getAllInfo(apot);
		//apot.printf(apot.getAllInfo(apot));
		/*if(Apothecary.insert(new Apothecary(5,"李大兴","12345"))){
			System.out.println("ye");
		};*/
		//Apothecary.delete(1);
		//Apothecary.update(new Apothecary(5,"李兴","1234578"));
	}

	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}
	
	public boolean insert(Apothecary apot) {
		getCon();
		boolean flag = false;
		//String sql = "insert into t_apothecary(id,name) value";
		try {
			ps = con.prepareStatement("insert into t_apothecary (id,name,password) values (?,?,?)");
			ps.setInt(1, apot.id);
			ps.setString(2, apot.name);
			ps.setString(3, apot.password);
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public  boolean delete(int id) {
		getCon();
		boolean result = false;
		String sql = "delete from t_apothecary where id=" + id ;
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
	
	public boolean update(Apothecary apot){
		getCon();
		boolean result = false;
		try {
			ps = con.prepareStatement("update t_apothecary set name=?, password=? where id=?");
			ps.setString(1, apot.getName());
			ps.setString(2, apot.getPassword());
			ps.setInt(3, apot.getId());
			con.setAutoCommit(false);
			ps.executeUpdate();
			result = true;
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Apothecary getInfo(Apothecary apot, int id) {
		getCon();
		String sql = "select * from t_apothecary where id=" + id ;
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				apot.id = rs.getInt("id");
				apot.name = rs.getString("name");
				apot.password  = rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apot;
	}
	
	public List<Apothecary> getAllInfo() {
		getCon();
		List<Apothecary> values = new ArrayList<Apothecary>();
		String sql = "select * from t_apothecary";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Apothecary apot = new Apothecary();
				apot.id = rs.getInt("id");
				apot.name = rs.getString("name");
				apot.password  = rs.getString("password");
				values.add(apot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}
	
	public static void printf(List<Apothecary> values) {
		Iterator<Apothecary> itor = values.iterator();
		while(itor.hasNext()) {
			//System.out.println(itor.toString());
			Apothecary apot = (Apothecary)itor.next();
			System.out.println(apot.toString());
		}
	}
	
	public boolean isHave(Apothecary apot,int id) {
		boolean result = false;
		//getCon();
		if(id == apot.getInfo(apot, id).id) {
			result = true;
		}
		return result;
	}
	
}
