package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_workgroup;

@Repository
public interface C_workgroup_Mapper {

	@Select("select count(*) from  C_workgroup   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_workgroup.* from  C_workgroup   ${where} ${limit}")
	public  List<C_workgroup> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_workgroup.* from  C_workgroup ")
	public  List<C_workgroup> getAll();

	@Select("select C_workgroup.* from C_workgroup  where id=#{id}")
	public  C_workgroup getByid(int id);

	@Delete("delete from C_workgroup where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_workgroup (name) values(#{name})")
	 public Integer insert(C_workgroup t);

	 @Update("update C_workgroup set name=#{name} where id=#{id}")
	 public Integer update(C_workgroup t);

}


