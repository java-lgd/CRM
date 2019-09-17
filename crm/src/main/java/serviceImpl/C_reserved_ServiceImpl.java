package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_reserved;
import mapper.C_reserved_Mapper;
import service.C_reserved_Service;

@Service
public class C_reserved_ServiceImpl implements C_reserved_Service{

	@Autowired
	C_reserved_Mapper m;

	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_reserved> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_reserved> getAll() {
		return m.getAll();
	}

	public C_reserved getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_reserved t) {
		return m.insert(t);
	}

	public Integer update(C_reserved t) {
		return m.update(t);
	}

}
