package aop;

import org.aspectj.lang.JoinPoint;

public class Advice {
    public void method1() {
        System.out.println("增强");
    }

    public void method2(JoinPoint joinPoint) {
        joinPoint.getArgs();
    }

    public void method3(Object obj) {
        System.out.println(obj);
    }
}
