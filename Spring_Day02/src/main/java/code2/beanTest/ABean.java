package code2.beanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ABean {
    @Value("啦啦啦")
    private String name;
    @Value("123")
    private Integer num;

    private SingletonBean singletonBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void method() {
        System.out.println(123);
    }

    public SingletonBean getSingletonBean() {
        return singletonBean;
    }

    @Autowired
    public void setSingletonBean(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }
}
