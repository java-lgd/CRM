package service;

import java.util.List;

import entity.C_product;

public interface C_product_Service {
	public int getSize(String where);

	public  List<C_product> getWhere(String where,String limit);

	public  List<C_product> getAll();

	public  C_product getByid(int id);

	public int delete(int id);

	 public Integer insert(C_product t);

	 public Integer update(C_product t);
}
