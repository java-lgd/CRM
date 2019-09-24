package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_operator;
import mapper.C_operator_Mapper;
import service.C_operator_Service;

@Service
public class C_operator_ServiceImpl implements C_operator_Service{

	@Autowired
	C_operator_Mapper m;
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_operator> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_operator> getAll() {
		return m.getAll();
	}

	public C_operator getUser(C_operator u) {
		return m.getUser(u);
	}
	
	public C_operator getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_operator t) {
		return m.insert(t);
	}

	public Integer update(C_operator t) {
		return m.update(t);
	}

	public C_operator login(C_operator u) {
		return m.login(u);
	}

}
