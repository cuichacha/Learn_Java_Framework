package code3.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeCount {
    public Object countTimeUsage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("方法用时：" + (end - start));
        return result;
    }
}
