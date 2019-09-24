package serviceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_order;
import mapper.C_order_Mapper;
import service.C_order_Service;

@Service
public class C_order_ServiceImpl implements C_order_Service{
	
	@Autowired
	C_order_Mapper m;

	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_order> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}
	
	public  List<C_order> getTable4(String where,String limit){
		return m.getTable4(where,limit);
	}

	public List<C_order> getAll() {
		return m.getAll();
	}

	public C_order getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_order t) {
		return m.insert(t);
	}

	public Integer update(C_order t) {
		return m.update(t);
	}

}
