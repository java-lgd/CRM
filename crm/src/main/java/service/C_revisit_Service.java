package service;

import java.util.List;

import entity.C_revisit;

public interface C_revisit_Service {

	public int getSize(String where);

	public  List<C_revisit> getWhere(String where,String limit);

	public  List<C_revisit> getAll();

	public  C_revisit getByid(int id);

	public int delete(int id);

	 public Integer insert(C_revisit t);

	 public Integer update(C_revisit t);
}
