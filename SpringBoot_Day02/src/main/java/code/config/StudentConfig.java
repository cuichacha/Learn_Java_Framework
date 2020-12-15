package code.config;

import code.pojo.Student;
import org.springframework.context.annotation.Bean;

public class StudentConfig {
    @Bean
    public Student getStudent() {
        return new Student();
    }
}
