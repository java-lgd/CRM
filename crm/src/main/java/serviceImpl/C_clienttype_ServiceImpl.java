package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_clienttype;
import mapper.C_clienttype_Mapper;
import service.C_clienttype_Service;

@Service
public class C_clienttype_ServiceImpl implements C_clienttype_Service{

	@Autowired
	C_clienttype_Mapper m;
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_clienttype> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_clienttype> getAll() {
		return m.getAll();
	}

	public C_clienttype getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_clienttype t) {
		return m.insert(t);
	}

	public Integer update(C_clienttype t) {
		return m.update(t);
	}

}
