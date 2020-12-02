package code2.dao;

import code2.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {

    @Insert("insert into account(name,money)values(#{name},#{money})")
    void save(Account account);

    @Delete("delete from account where id = #{id} ")
    void delete(Integer id);

    @Update("update account set name = #{name} , money = #{money} where id = #{id} ")
    void update(Account account);

    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account where id = #{id} ")
    Account findById(Integer id);

    @Update("update account set money = money + #{money} where name = #{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update account set money = money - #{money} where name = #{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);
}