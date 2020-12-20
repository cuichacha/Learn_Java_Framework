package code.test;

import code.anno.EnableStudent1;
import code.anno.EnableStudent2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableStudent1
//@EnableStudent2
public class TestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestApplication.class, args);
        Object student = context.getBean("student");
        System.out.println(student);
    }
}
