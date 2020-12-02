package code4.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCount {
    @Pointcut("execution(* code4.service.*.*.find*(..))")
    public void pointCut() {}

    private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    @Before("pointCut()")
    public void countTimeBefore() {
        long start = System.currentTimeMillis();
        threadLocal.set(start);
    }

    @AfterReturning("pointCut()")
    public void countTimeAfter() {
        Long start = threadLocal.get();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
