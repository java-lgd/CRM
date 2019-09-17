package service;

import java.util.List;

import entity.C_orderdetails;

public interface C_orderdetails_Service {
	
	public int getSize(String where);

	public  List<C_orderdetails> getWhere( String where,String limit);

	public  List<C_orderdetails> getAll();

	public  C_orderdetails getByid(int id);

	public int delete(int id);

	 public Integer insert(C_orderdetails t);

	 public Integer update(C_orderdetails t);

}
