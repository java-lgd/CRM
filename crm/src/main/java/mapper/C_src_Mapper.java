package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_src;

@Repository
public interface C_src_Mapper {

	@Select("select count(*) from  C_src   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_src.* from  C_src   ${where} ${limit}")
	public  List<C_src> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_src.* from  C_src ")
	public  List<C_src> getAll();

	@Select("select C_src.* from C_src  where id=#{id}")
	public  C_src getByid(int id);

	@Delete("delete from C_src where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_src (name) values(#{name})")
	 public Integer insert(C_src t);

	 @Update("update C_src set name=#{name} where id=#{id}")
	 public Integer update(C_src t);

}


