package code1.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    @Update("update account set money = money + #{money} where name = #{name}")
    public abstract void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update account set money = money - #{money} where name = #{name}")
    public abstract void outMoney(@Param("name") String name, @Param("money") Double money);
}
