package hospital.business.medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hospital.db.DataBase;

public class Medicine {
	private int id;
	private String name;
	private float price;
	private int stock;
	private int saled;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSaled() {
		return saled;
	}
	public void setSaled(int saled) {
		this.saled = saled;
	}
	
	
	
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", saled=" + saled
				+ "]";
	}
	
	public static void getCon() {
		db = new DataBase();
		con = db.getCon();
	}
	
	public Medicine getInfo(Medicine med,String name) {
		getCon();
		//Medicine med = new Medicine();
		//med.name = name;
		//med.setName(name);
		String sql = "select * from t_medicine where name=" + "'" + name + "'";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				/*med.setId(rs.getInt("id"));
				med.setPrice(rs.getFloat("price"));
				med.setSaled(rs.getInt("saled"));
				med.setStock(rs.getInt("stock"));*/
				med.id = rs.getInt("id");
				med.price = rs.getFloat("price");
				med.name= rs.getString("name");
				med.saled = rs.getInt("saled");
				med.stock = rs.getInt("stock");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return med;
	}
	
	public String nameObtain(int medicineid) {
		getCon();
		String name = null;
		try {
			ps = con.prepareStatement("select name from t_medicine where id=?");
			ps.setInt(1, medicineid);
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
	
	public static boolean isHave(Medicine med, String Name) {
		boolean result =false;
		if(Name.equals(med.getInfo(med, Name).name)) {
			result = true;
		}
		return result;
	}
	
	public static void takeSale(Medicine med,String name, int saled) {
		getCon();
		 //String sql = "update t_medicine set saled=saled+" + saled + "," + "stock=stock-" + saled + " where name=" + "'" + name + "'";
		String sql = "select id from t_medicine where name=" + "'" + name + "'";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String sql_num = "update t_medicine set saled=saled+" + saled + "," + "stock=stock-" + saled + " where id=" + rs.getInt("id");
				System.out.println(sql_num);
				ps = con.prepareStatement(sql_num);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Medicine med = new Medicine();
		//System.out.println((new Medicine()).getInfo(med,"ÔÆÄÏ°×Ò©").toString());
		//System.out.println(med.getInfo(med,"ÔÆÄÏ°×Ò©").toString());
		//takeSale(med,"ÔÆÄÏ°×Ò©",3);
		//System.out.println(Medicine.nameObtain(1));
	}
}






























