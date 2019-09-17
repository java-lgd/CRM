package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.C_workgroup;
import mapper.C_workgroup_Mapper;
import service.C_workgroup_Service;

@Service
public class C_workgroup_ServiceImpl implements C_workgroup_Service{

	@Autowired
	C_workgroup_Mapper m;
	
	public int getSize(String where) {
		return m.getSize(where);
	}

	public List<C_workgroup> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}

	public List<C_workgroup> getAll() {
		return m.getAll();
	}

	public C_workgroup getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_workgroup t) {
		return m.insert(t);
	}

	public Integer update(C_workgroup t) {
		return m.update(t);
	}

}
