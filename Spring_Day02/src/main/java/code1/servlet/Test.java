package code1.servlet;

import code1.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import code1.service.AccountService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
//        System.out.println(dataSource);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService.findAll());
    }
}
