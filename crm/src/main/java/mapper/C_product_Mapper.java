package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.C_product;

@Repository
public interface C_product_Mapper {

	@Select("select count(*) from  C_product   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_product.* from  C_product   ${where} ${limit}")
	public  List<C_product> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_product.* from  C_product ")
	public  List<C_product> getAll();

	@Select("select C_product.* from C_product  where id=#{id}")
	public  C_product getByid(int id);

	@Delete("delete from C_product where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_product (name,amount,info) values(#{name},#{amount},#{info})")
	 public Integer insert(C_product t);

	 @Update("update C_product set name=#{name},amount=#{amount},info=#{info} where id=#{id}")
	 public Integer update(C_product t);

}


