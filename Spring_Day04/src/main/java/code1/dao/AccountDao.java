package code1.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    @Update("update db_spring set money = money + #{money} where name = #{name}")
    public abstract void inMonet(@Param("name") String name, @Param("money") Double money);

    @Update("update db_spring set money = money - #{money} where name = #{name}")
    public abstract void outMonet(@Param("name") String name, @Param("money") Double money);
}
