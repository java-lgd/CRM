package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_product;
import mapper.C_product_Mapper;
import service.C_product_Service;

@Service
public class C_product_ServiceImpl implements C_product_Service{

	@Autowired
	C_product_Mapper m;
	
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_product> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_product> getAll() {
		return m.getAll();
	}

	public C_product getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_product t) {
		return m.insert(t);
	}

	public Integer update(C_product t) {
		return m.update(t);
	}

}
