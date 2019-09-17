package service;

import java.util.List;

import entity.C_workgroup;

public interface C_workgroup_Service {
	public int getSize(String where);

	public  List<C_workgroup> getWhere(String where,String limit);

	public  List<C_workgroup> getAll();

	public  C_workgroup getByid(int id);

	public int delete(int id);

	 public Integer insert(C_workgroup t);

	 public Integer update(C_workgroup t);
}
