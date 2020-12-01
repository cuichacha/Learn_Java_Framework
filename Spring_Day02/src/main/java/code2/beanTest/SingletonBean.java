package code2.beanTest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    public void method() {
        System.out.println(111);
    }
}
