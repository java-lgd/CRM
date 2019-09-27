package utils;

import java.util.List;

public class ReturnInfo {
	private int count=0;
	private int code=0;
	private String msg="";
	private List<?> data;
	
	public ReturnInfo() {
		// TODO Auto-generated constructor stub
	}
public ReturnInfo(List<?> data) {
	this.count=data.size();
	this.data=data;
}
	public String getLimit(Integer page,Integer max) {
		if(page==null) return "";
		return " limit "+((page-1)*max)+","+max;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
	
}
