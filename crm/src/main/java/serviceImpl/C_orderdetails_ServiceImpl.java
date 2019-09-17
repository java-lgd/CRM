package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_orderdetails;
import mapper.C_orderdetails_Mapper;
import service.C_orderdetails_Service;

@Service
public class C_orderdetails_ServiceImpl implements C_orderdetails_Service{

	@Autowired
	C_orderdetails_Mapper m;
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_orderdetails> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_orderdetails> getAll() {
		return m.getAll();
	}

	public C_orderdetails getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_orderdetails t) {
		return m.insert(t);
	}

	public Integer update(C_orderdetails t) {
		return m.update(t);
	}

}
