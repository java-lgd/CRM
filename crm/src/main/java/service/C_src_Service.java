package service;

import java.util.List;

import entity.C_src;

public interface C_src_Service{
	public int getSize(String where);

	public  List<C_src> getWhere(String where,String limit);

	public  List<C_src> getAll();

	public  C_src getByid(int id);

	public int delete(int id);

	 public Integer insert(C_src t);

	 public Integer update(C_src t);
}
