package code.config;

import code.factory.JDBCFactory;
import code.factory.TransactionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"code.dao", "code.service", "code.aop"})
@Import({JDBCFactory.class, TransactionFactory.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {

}
