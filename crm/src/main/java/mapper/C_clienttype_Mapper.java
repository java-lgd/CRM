package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_clienttype;

@Repository
public interface C_clienttype_Mapper {

	@Select("select count(*) from  C_clienttype   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_clienttype.* from  C_clienttype   ${where} ${limit}")
	public  List<C_clienttype> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_clienttype.* from  C_clienttype ")
	public  List<C_clienttype> getAll();

	@Select("select C_clienttype.* from C_clienttype  where id=#{id}")
	public  C_clienttype getByid(int id);

	@Delete("delete from C_clienttype where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_clienttype (name) values(#{name})")
	 public Integer insert(C_clienttype t);

	 @Update("update C_clienttype set name=#{name} where id=#{id}")
	 public Integer update(C_clienttype t);

}


