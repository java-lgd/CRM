package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_order;

@Repository
public interface C_order_Mapper {

	@Select("select count(*) from  C_order   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_order.*,C_client.name clientname,C_operator.name operator from  C_order inner join c_client on C_order.clientid=c_client.id inner join c_operator on C_order.operatorid=c_operator.id ${where} ${limit}")
	public  List<C_order> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_order.* from  C_order ")
	public  List<C_order> getAll();

	@Select("select C_order.* from C_order  where id=#{id}")
	public  C_order getByid(int id);

	@Delete("delete from C_order where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_order (clientid,createdate,compdate,orderdate,startdate,enddate,operatorid,info,files,compoperatorids,compweight,status,amount,comments) values(#{clientid},#{createdate},#{compdate},#{orderdate},#{startdate},#{enddate},#{operatorid},#{info},#{files},#{compoperatorids},#{compweight},#{status},#{amount},#{comments})")
	 public Integer insert(C_order t);

	 @Update("update C_order set clientid=#{clientid},createdate=#{createdate},compdate=#{compdate},orderdate=#{orderdate},startdate=#{startdate},enddate=#{enddate},operatorid=#{operatorid},info=#{info},files=#{files},compoperatorids=#{compoperatorids},compweight=#{compweight},status=#{status},amount=#{amount},comments=#{comments} where id=#{id}")
	 public Integer update(C_order t);

}
