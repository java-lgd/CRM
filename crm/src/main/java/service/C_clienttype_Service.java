package service;

import java.util.List;

import entity.C_clienttype;

public interface C_clienttype_Service {
	public int getSize(String where);

	public  List<C_clienttype> getWhere(String where,String limit);

	public  List<C_clienttype> getAll();

	public  C_clienttype getByid(int id);

	public int delete(int id);

	 public Integer insert(C_clienttype t);

	 public Integer update(C_clienttype t);
}
