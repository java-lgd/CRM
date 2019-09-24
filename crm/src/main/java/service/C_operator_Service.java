package service;

import java.util.List;

import entity.C_operator;

public interface C_operator_Service {
	
	public C_operator login(C_operator u);
	
	public int getSize( String where);

	public  List<C_operator> getWhere(String where,String limit);

	public  List<C_operator> getAll();

	public C_operator getUser(C_operator u);
	
	public  C_operator getByid(int id);

	public int delete(int id);

	public Integer insert(C_operator t);

	public Integer update(C_operator t);


}
