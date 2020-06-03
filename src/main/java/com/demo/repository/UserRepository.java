package com.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.model.User;

@Mapper
public interface UserRepository {

	@Select("select * from users")
	@Results(value = {
			@Result(property = "id",column="id"),
			@Result(property = "firstName",column="first_name"),
			@Result(property = "lastName",column="last_name"),
			@Result(property = "email",column = "email")
	})
	List<User>findAll();
	
	@Select("select * from users where id=#{id}")
	@Results(value = {
			@Result(property = "id",column="id"),
			@Result(property = "firstName",column="first_name"),
			@Result(property = "lastName",column="last_name"),
			@Result(property = "email",column = "email")
	})
	User findById(int id);
	
	@Insert("insert into users (first_name,last_name,email) values"
			+ "(#{firstName},#{lastName},#{email})")
	public int insert(User user);
	
	@Update("update users set first_name=#{firstName},last_name=#{lastName},email=#{email} where id=#{id}")
	public int update(User user);
	
	@Delete("delete from users where id=#{id}")
	public int delete(int id);
	
}
