package code1.config;

import code1.factory.JDBCFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"code1.dao", "code1.service", "code1.domain", "code1.factory"})
@Import(JDBCFactory.class)
public class AppConfig {
}
