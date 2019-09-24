package service;

import java.util.List;

import entity.C_client;
import entity.C_operator;

public interface C_client_Service {
	
	public int getSize( String where);

	public  List<C_client> getWhere(String where,String limit);

	public  List<C_client> getTable(String where,String limit);
	
	public  List<C_client> getTable1(String where,String limit);
	
	public  List<C_client> getTable6(String where,String limit);
	
	public  List<C_client> getAll();

	public  C_client getByid(int id);

	public int delete(int id);

	public Integer insert(C_client t);

	public Integer update(C_client t);


}
