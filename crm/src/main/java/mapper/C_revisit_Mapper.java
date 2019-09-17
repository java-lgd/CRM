package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_revisit;

@Repository
public interface C_revisit_Mapper {
	
	@Select("select count(*) from  C_revisit   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_revisit.* from  C_revisit   ${where} ${limit}")
	public  List<C_revisit> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_revisit.* from  C_revisit ")
	public  List<C_revisit> getAll();

	@Select("select C_revisit.* from C_revisit  where id=#{id}")
	public  C_revisit getByid(int id);

	@Delete("delete from C_revisit where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_revisit (clientid,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,askinfo,followinfo,probleminfo,status,comments) values(#{clientid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	 public Integer insert(C_revisit t);

	 @Update("update C_revisit set clientid=#{clientid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	 public Integer update(C_revisit t);

}
