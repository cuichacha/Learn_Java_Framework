package code.config;

import code.condition.ConditionOnClass;
import code.condition.MyCondition;
import code.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean("user")
//    @Conditional(MyCondition.class)
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User getUser() {
        return new User();
    }
}
