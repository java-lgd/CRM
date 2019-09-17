package entity;

public class C_order {

	private Integer id;
	private Integer clientid;
	private String clientname;
	private String createdate;
	private String compdate;
	private String orderdate;
	private String startdate;
	private String enddate;
	private Integer operatorid;
	private String operator;
	private String info;
	private String files;
	private String compoperatorids;
	private String compweight;
	private Integer status;
	public static String[] statuses = {"Î´ÉóºË","ÒÑÉóºË","ÔÝ»ºÒµ¼¨","×÷·Ï"};
	public String getStatusname() {
		return statuses[status];
	}
	private double amount;
	private String comments;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCompdate() {
		return compdate;
	}

	public void setCompdate(String compdate) {
		this.compdate = compdate;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Integer getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getCompoperatorids() {
		return compoperatorids;
	}

	public void setCompoperatorids(String compoperatorids) {
		this.compoperatorids = compoperatorids;
	}

	public String getCompweight() {
		return compweight;
	}

	public void setCompweight(String compweight) {
		this.compweight = compweight;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

}
