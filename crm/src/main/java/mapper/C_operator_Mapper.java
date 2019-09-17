package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_operator;

@Repository
public interface C_operator_Mapper {
	
	@Select("select * from C_operator where tel=#{tel} and pass=#{pass}")
	public C_operator login(C_operator u);

	@Select("select count(*) from  C_operator  ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_operator.*,C_workgroup.name groupname from  C_operator inner join C_workgroup on C_operator.groupid=C_workgroup.id  ${where} ${limit}")
	public  List<C_operator> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_operator.* from  C_operator ")
	public  List<C_operator> getAll();

	@Select("select C_operator.* from C_operator  where id=#{id}")
	public  C_operator getByid(int id);

	@Delete("delete from C_operator where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_operator (tel,pass,name,groupid,power,status) values(#{tel},#{pass},#{name},#{groupid},#{power},#{status})")
	 public Integer insert(C_operator t);

	 @Update("update C_operator set tel=#{tel},pass=#{pass},name=#{name},groupid=#{groupid},power=#{power},status=#{status} where id=#{id}")
	 public Integer update(C_operator t);

}

