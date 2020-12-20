package code.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCount {

    @Pointcut("execution(* *.test.*.*(..))")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object countTime(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return proceed;
    }
}
