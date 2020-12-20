package code.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ComponentScan({"code.aoptest"})
@EnableAspectJAutoProxy
public class AOPConfig {

}
