package code.anno;

import code.config.StudentConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(StudentConfig.class)
public @interface EnableStudent1 {


}
