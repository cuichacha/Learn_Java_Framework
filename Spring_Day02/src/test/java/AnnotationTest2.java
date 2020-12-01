import code2.beanTest.ABean;
import code2.beanTest.PrototypeBean;
import code2.beanTest.SingletonBean;
import code2.config.AppConfig;
import code2.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnnotationTest2 {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    public void test1() {
        ABean aBean = (ABean) applicationContext.getBean("ABean");
        System.out.println(aBean.getName());
        System.out.println(aBean.getNum());
        aBean.method();
    }

    @Test
    public void test2() {
        SingletonBean singletonBean1 = (SingletonBean) applicationContext.getBean("singletonBean");
        SingletonBean singletonBean2 = (SingletonBean) applicationContext.getBean("singletonBean");
        SingletonBean singletonBean3 = (SingletonBean) applicationContext.getBean("singletonBean");
        System.out.println(singletonBean1);
        System.out.println(singletonBean2);
        System.out.println(singletonBean3);
    }

    @Test
    public void test3() {
        PrototypeBean prototypeBean1 = (PrototypeBean) applicationContext.getBean("prototypeBean");
        PrototypeBean prototypeBean2 = (PrototypeBean) applicationContext.getBean("prototypeBean");
        PrototypeBean prototypeBean3 = (PrototypeBean) applicationContext.getBean("prototypeBean");
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
        System.out.println(prototypeBean3);
    }

    @Test
    public void test4() {
        ABean aBean = (ABean) applicationContext.getBean("ABean");
        SingletonBean singletonBean = aBean.getSingletonBean();
        singletonBean.method();
    }

}
