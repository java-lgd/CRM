package entity;

public class C_operator{

	private Integer id;
	private String tel;
	private String pass;
	private String name;
	private Integer groupid;
	private String groupname;
	private Integer power;
	private Integer status;
	public static String[] statuses = {"启用","禁用"};
	public static String[] powers = {"管理员","组长","组员"};
	public String getPowername() {
		return powers[power];
	}
	public String getStatusname() {
		return statuses[status];
	}
	
	public C_operator() {
	}

	public C_operator(Integer id, String tel, String pass, String name, Integer groupid, Integer power,
			Integer status) {
		super();
		this.id = id;
		this.tel = tel;
		this.pass = pass;
		this.name = name;
		this.groupid = groupid;
		this.power = power;
		this.status = status;
	}

	public C_operator(String tel, String pass) {
		super();
		this.tel = tel;
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

}
