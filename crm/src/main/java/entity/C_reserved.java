package entity;

public class C_reserved {
	private Integer id;
	private Integer revisitid;
	private Integer clientid;
	private String clientname;
	private String createdate;
	private Integer operatorid;
	private String operator;
	private String date;
	private Integer execoperatorid;
	private String execoperator;
	private Integer type;
	public static String[] types = {"秒挂","未通","有交流","深入交流"};
	public String getTypename() {
		return types[type];
	}
	private Integer status;
	public static String[] statuses = {"秒挂","未通","有交流","深入交流"};
	public String getStatusname() {
		return statuses[status];
	}
	private Integer execstatus;
	public static String[] execstatuses = {"秒挂","未通","有交流","深入交流"};
	public String getExecstatusname() {
		return execstatuses[execstatus];
	}
	private String result;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRevisitid() {
		return revisitid;
	}

	public void setRevisitid(Integer revisitid) {
		this.revisitid = revisitid;
	}

	public Integer getClientid() {
		return clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getExecoperatorid() {
		return execoperatorid;
	}

	public void setExecoperatorid(Integer execoperatorid) {
		this.execoperatorid = execoperatorid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getExecstatus() {
		return execstatus;
	}

	public void setExecstatus(Integer execstatus) {
		this.execstatus = execstatus;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getExecoperator() {
		return execoperator;
	}

	public void setExecoperator(String execoperator) {
		this.execoperator = execoperator;
	}


}
