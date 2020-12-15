package code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ConditionApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(ConditionApplication.class, args);
//        Object redisTemplate = context.getBean("redisTemplate");
//        System.out.println(redisTemplate);

//        Object user = context.getBean("user");
//        System.out.println(user);

        Object student = context.getBean("student");
        System.out.println(student);
    }
}
