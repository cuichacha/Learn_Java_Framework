package code1.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        final SuperInterface superInterface = new BeDynamicallyProxied();

        SuperInterface proxiedObj = (SuperInterface) Proxy.newProxyInstance(superInterface.getClass().getClassLoader(), new Class[]{SuperInterface.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("method".equals(method.getName())) {
                    System.out.println(222);
                    return null;
                }
                return method.invoke(superInterface, args);
            }
        });

        proxiedObj.method();
    }
}
