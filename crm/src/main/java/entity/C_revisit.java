package entity;

public class C_revisit{

	private Integer id;
	private String clientid;
	private Integer linkstatus;
	public static String[] links = {"秒挂","未通","有交流","深入交流"};
	public String getLinksname() {
		return links[linkstatus];
	}
	private Integer clientstatus;
	public static String[] clients = {"排斥","推脱","后续","较好"};
	public String getClientsname() {
		return clients[clientstatus];
	}
	private Integer purposestatus;
	public static String[] purposes = {"N","C","B","A","Y"};
	public String getPurposessname() {
		return purposes[purposestatus];
	}
	private Integer assessstatus;
	public static String[] assess = {"截止","无果","有预约"};
	public String getAssessstatusname() {
		return assess[assessstatus];
	}
	private Integer execstatus;
	public static String[] execs = {"正常","转出","完成"};
	public String getExecstatusname() {
		return execs[execstatus];
	}
	private String askinfo;
	private String followinfo;
	private String probleminfo;
	private Integer status;
	private String comments;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public Integer getLinkstatus() {
		return linkstatus;
	}

	public void setLinkstatus(Integer linkstatus) {
		this.linkstatus = linkstatus;
	}

	public Integer getClientstatus() {
		return clientstatus;
	}

	public void setClientstatus(Integer clientstatus) {
		this.clientstatus = clientstatus;
	}

	public Integer getPurposestatus() {
		return purposestatus;
	}

	public void setPurposestatus(Integer purposestatus) {
		this.purposestatus = purposestatus;
	}

	public Integer getAssessstatus() {
		return assessstatus;
	}

	public void setAssessstatus(Integer assessstatus) {
		this.assessstatus = assessstatus;
	}

	public Integer getExecstatus() {
		return execstatus;
	}

	public void setExecstatus(Integer execstatus) {
		this.execstatus = execstatus;
	}

	public String getAskinfo() {
		return askinfo;
	}

	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}

	public String getFollowinfo() {
		return followinfo;
	}

	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}

	public String getProbleminfo() {
		return probleminfo;
	}

	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
