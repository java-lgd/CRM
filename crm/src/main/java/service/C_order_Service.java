package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.C_order;

public interface C_order_Service {
	
	public int getSize(String where);

	public  List<C_order> getWhere(String where,String limit);
	
	public  List<C_order> getTable4(String where,String limit);

	public  List<C_order> getAll();
	
	public  C_order getByid(int id);

	public int delete(int id);

	public Integer insert(C_order t);

	 public Integer update(C_order t);
}
