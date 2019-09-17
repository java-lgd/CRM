package service;

import java.util.List;

import entity.C_reserved;

public interface C_reserved_Service {
	
	public int getSize(String where);

	public  List<C_reserved> getWhere(String where,String limit);

	public  List<C_reserved> getAll();

	public  C_reserved getByid(int id);

	public int delete(int id);

	 public Integer insert(C_reserved t);

	 public Integer update(C_reserved t);

}
