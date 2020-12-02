package code4.config;

import code4.factory.JDBCFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"code4.dao", "code4.service", "code4.aop"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCFactory.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
