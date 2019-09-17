package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_revisit;
import mapper.C_revisit_Mapper;
import service.C_revisit_Service;

@Service
public class C_revisit_ServiceImpl implements C_revisit_Service{

	@Autowired
	C_revisit_Mapper m;
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_revisit> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_revisit> getAll() {
		return m.getAll();
	}

	public C_revisit getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_revisit t) {
		return m.insert(t);
	}

	public Integer update(C_revisit t) {
		return m.update(t);
	}

}
