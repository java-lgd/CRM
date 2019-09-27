package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.C_client;
import mapper.C_client_Mapper;
import service.C_client_Service;

@Service
public class C_client_ServiceImpl implements C_client_Service{

	@Autowired
	C_client_Mapper m;
	public int getSize(String where) {
		return m.getSize(where);
	}

	
	
	public List<C_client> getWhere(String where, String limit) {
		return m.getWhere(where, limit);
	}
	
	public List<C_client> getTable(String where, String limit) {
		return m.getTable(where, limit);
	}

	public  List<C_client> getTable1(String where,String limit){
		return m.getTable1(where, limit);
	}
	
	public List<C_client> getTable6(String where, String limit) {
		return m.getTable6(where, limit);
	}
	
	public List<C_client> getAll() {
		return m.getAll();
	}

	public C_client getByid(int id) {
		return m.getByid(id);
	}

	public int delete(int id) {
		return m.delete(id);
	}

	public Integer insert(C_client t) {
		return m.insert(t);
	}

	public Integer update(C_client t) {
		return m.update(t);
	}

	public Integer update1(Integer id,String operatorids,String operatornames) {
		return m.update1(id, operatorids, operatornames);
	}
}
