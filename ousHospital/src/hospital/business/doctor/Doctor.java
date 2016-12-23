package hospital.business.doctor;

public class Doctor {
	private String id;
	private String name;
	private String tel;
	private int age;
	private String depatid;
	private String status; 
	private String comment;
	
	
	public Doctor(String id, String name, int age, String depatid, String status) {
		super();
		this.id = id;
		this.name = name;
		//this.tel = tel;
		this.age = age;
		this.depatid = depatid;
		this.status = status;
		//this.comment = comment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepatid() {
		return depatid;
	}
	public void setDepatid(String depatid) {
		this.depatid = depatid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
