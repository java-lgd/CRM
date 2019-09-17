package entity;

public class C_client {

	private Integer id;
	private String name;
	private Integer sex;
	public static String[] sexs = {"男","女"};
	public String getSexname() {
		return sexs[sex];
	}
	private String tel;
	private String qq;
	private String email;
	private String infos;
	private Integer linkstatus;
	public static String[] links = {"未指定","秒挂","未通","有交流","深入交流"};
	public String getLinkname() {
		return links[linkstatus];
	}
	private Integer clientstatus;
	public static String[] clients = {"未指定","排斥","推脱","后续","较好"};
	public String getClientsname() {
		return clients[clientstatus];
	}
	private Integer purposestatus;
	public static String[] purposes = {"未指定","N","C","B","A","Y"};
	public String getPurposename() {
		return purposes[purposestatus];
	}
	private Integer assessstatus;
	public static String[] assess = {"未指定","截止","无果","有预约"};
	public String getAssessname() {
		return assess[assessstatus];
	}
	private Integer execstatus;
	public static String[] execs = {"正常","转出","完成"};
	public String getExecname() {
		return execs[execstatus];
	}
	private Integer status;
	public static String[] statuses = {"正常","公共","资料不全","无效"};
	public String getStatusname() {
		return statuses[status];
	}
	private Integer clienttypeid;
	private String clientname;
	private String operatorids;
	private String operatornames;
	private Integer createoperatorid;
	private String operatorname;
	private String createdate;
	private Integer srcid;
	private String srcname;
	private Integer count;
	private String comments;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getClienttypeid() {
		return clienttypeid;
	}

	public void setClienttypeid(Integer clienttypeid) {
		this.clienttypeid = clienttypeid;
	}

	public String getOperatorids() {
		return operatorids;
	}

	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}

	public Integer getCreateoperatorid() {
		return createoperatorid;
	}

	public void setCreateoperatorid(Integer createoperatorid) {
		this.createoperatorid = createoperatorid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getSrcid() {
		return srcid;
	}

	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public String getSrcname() {
		return srcname;
	}

	public void setSrcname(String srcname) {
		this.srcname = srcname;
	}

	public String getOperatornames() {
		return operatornames;
	}

	public void setOperatornames(String operatornames) {
		this.operatornames = operatornames;
	}

}
