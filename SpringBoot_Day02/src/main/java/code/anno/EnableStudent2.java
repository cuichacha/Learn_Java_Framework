package code.anno;

import code.config.StudentConfig;
import code.pojo.Student;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(Student.class)
public @interface EnableStudent2 {
}
