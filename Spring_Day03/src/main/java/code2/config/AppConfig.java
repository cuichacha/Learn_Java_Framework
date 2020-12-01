package code2.config;

import code2.factory.JDBCFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"code2.dao", "code2.service"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCFactory.class)
public class AppConfig {
}
