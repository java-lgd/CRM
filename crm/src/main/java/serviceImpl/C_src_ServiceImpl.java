package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_src;
import mapper.C_src_Mapper;
import service.C_src_Service;

@Service
public class C_src_ServiceImpl implements C_src_Service{

	@Autowired
	C_src_Mapper m;
	
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_src> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_src> getAll() {
		return m.getAll();
	}

	public C_src getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_src t) {
		return m.insert(t);
	}

	public Integer update(C_src t) {
		return m.update(t);
	}

}
