package code2.config;

import code2.factory.JDBCFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"code2.dao", "code2.service", "code2.aoptest"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCFactory.class)
@EnableAspectJAutoProxy
public class AppConfig {
}
