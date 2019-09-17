package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_orderdetails;

@Repository
public interface C_orderdetails_Mapper {

	@Select("select count(*) from  C_orderdetails   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_orderdetails.*,c_product.name productname from  C_orderdetails inner join C_product on C_orderdetails.productid=C_product.id ${where} ${limit}")
	public  List<C_orderdetails> getWhere(@Param("where") String where,@Param("limit") String limit);

	@Select("select C_orderdetails.* from  C_orderdetails ")
	public  List<C_orderdetails> getAll();

	@Select("select C_orderdetails.* from C_orderdetails  where id=#{id}")
	public  C_orderdetails getByid(int id);

	@Delete("delete from C_orderdetails where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_orderdetails (orderid,productid,count,amount,desc,comments) values(#{orderid},#{productid},#{count},#{amount},#{desc},#{comments})")
	 public Integer insert(C_orderdetails t);

	 @Update("update C_orderdetails set orderid=#{orderid},productid=#{productid},count=#{count},amount=#{amount},desc=#{desc},comments=#{comments} where id=#{id}")
	 public Integer update(C_orderdetails t);

}
