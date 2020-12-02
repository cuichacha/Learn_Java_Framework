package code3.config;

import code3.factory.JDBCFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"code3.dao", "code3.service"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCFactory.class)
@EnableTransactionManagement
public class AppConfig {
}
