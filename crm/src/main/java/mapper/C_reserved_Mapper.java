package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_reserved;

@Repository
public interface C_reserved_Mapper {
	@Select("select count(*) from  C_reserved   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_reserved.*,C_client.name clientname,a.name operator,b.name execoperator from  C_reserved inner join c_client on C_reserved.clientid=C_client.id inner join c_operator a on c_reserved.operatorid=a.id inner join c_operator  b on c_reserved.execoperatorid=b.id ${where} ${limit}")
	public  List<C_reserved> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_reserved.* from  C_reserved ")
	public  List<C_reserved> getAll();

	@Select("select C_reserved.* from C_reserved  where id=#{id}")
	public  C_reserved getByid(int id);

	@Delete("delete from C_reserved where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_reserved (revisitid,clientid,createdate,operatorid,date,execoperatorid,type,status,execstatus,result) values(#{revisitid},#{clientid},#{createdate},#{operatorid},#{date},#{execoperatorid},#{type},#{status},#{execstatus},#{result})")
	 public Integer insert(C_reserved t);

	 @Update("update C_reserved set revisitid=#{revisitid},clientid=#{clientid},createdate=#{createdate},operatorid=#{operatorid},date=#{date},execoperatorid=#{execoperatorid},type=#{type},status=#{status},execstatus=#{execstatus},result=#{result} where id=#{id}")
	 public Integer update(C_reserved t);


}
