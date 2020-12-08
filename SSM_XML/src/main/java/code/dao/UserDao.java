package code.dao;

import code.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    public abstract List<User> findAll();

    @Select("select * from user where id = #{id}")
    public abstract User findById(Integer id);

    @Insert("insert into user (userName,password,realName,gender,birthday)values(#{userName},#{password},#{realName},#{gender},#{birthday})")
    public abstract boolean save(User user);

    @Update("update user set userName=#{userName},password=#{password},realName=#{realName},gender=#{gender},birthday=#{birthday} where id=#{id}")
    public abstract boolean update(User user);

    @Delete("delete from user where id = #{id}")
    public abstract boolean delete(Integer id);

    @Select("select * from user where username = #{username} and password = #{password}")
    public abstract User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
