package code3.dao;

import code3.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Update("update account set money = money + #{money} where name = #{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update account set money = money - #{money} where name = #{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);
}