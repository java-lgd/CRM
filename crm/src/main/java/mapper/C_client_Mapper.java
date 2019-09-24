package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_client;
import entity.C_operator;

@Repository
public interface C_client_Mapper {
	
	@Select("select count(*) from  C_client ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_client.*,C_clienttype.name clientname,c_operator.name operatorname,c_src.name srcname from  C_client inner join c_operator on C_client.createoperatorid=c_operator.id inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id ${where} ${limit}")
	public  List<C_client> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_client.*,C_clienttype.name clientname,c_operator.name operatorname,c_src.name srcname from  C_client inner join c_operator on C_client.createoperatorid=c_operator.id inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id ${where} and C_client.count=0 AND LENGTH(c_client.operatorids)=0 ${limit} ")
	public  List<C_client> getTable(@Param("where")String where,@Param("limit")String limit);
	
	@Select("select C_client.*,C_clienttype.name clientname,c_operator.name operatorname,c_src.name srcname from  C_client inner join c_operator on C_client.createoperatorid=c_operator.id inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id ${where} and C_client.count=0  ${limit} ")
	public  List<C_client> getTable1(@Param("where")String where,@Param("limit")String limit);
	
	@Select("select C_client.*,C_clienttype.name clientname,c_operator.name operatorname,c_src.name srcname from  C_client inner join c_operator on C_client.createoperatorid=c_operator.id inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id ${where} and C_client.count>0 and LENGTH(c_client.operatorids)=0 ${limit} ")
	public  List<C_client> getTable6(@Param("where")String where,@Param("limit")String limit);
	
	@Select("select C_client.* from  C_client ")
	public  List<C_client> getAll();

	@Select("select C_client.* from C_client  where id=#{id}")
	public  C_client getByid(int id);

	@Delete("delete from C_client where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_client (name,sex,tel,qq,email,infos,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,status,clienttypeid,operatorids,operatornames,createoperatorid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{infos},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{status},#{clienttypeid},#{operatorids},#{operatornames},#{createoperatorid},#{createdate},#{srcid},#{count},#{comments})")
	 public Integer insert(C_client t);

	 @Update("update C_client set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},email=#{email},infos=#{infos},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},status=#{status},clienttypeid=#{clienttypeid},operatorids=#{operatorids},operatornames=#{operatornames},createoperatorid=#{createoperatorid},createdate=#{createdate},srcid=#{srcid},count=#{count},comments=#{comments} where id=#{id}")
	 public Integer update(C_client t);


}
