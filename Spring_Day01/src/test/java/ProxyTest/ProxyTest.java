package ProxyTest;

import code2.proxy.dynamicProxy.BeDynamicallyProxied;
import code2.proxy.staticProxy.BeStaticallyProxied;
import code2.proxy.staticProxy.StaticProxy;
import code2.proxy.staticProxy.TheInterface;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void staticProxyTest() {
        TheInterface theInterface1 = new BeStaticallyProxied();
        theInterface1.method();

        System.out.println();

        TheInterface theInterface2 = new StaticProxy(theInterface1);
        theInterface2.method();
    }

    @Test
    public void dynamicProxyTest() {
        final code2.proxy.dynamicProxy.TheInterface theInterface = new BeDynamicallyProxied();

        code2.proxy.dynamicProxy.TheInterface proxiedInterface = (code2.proxy.dynamicProxy.TheInterface) Proxy.newProxyInstance(theInterface.getClass().getClassLoader(), new Class[]{code2.proxy.dynamicProxy.TheInterface.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("method".equals(method.getName())) {
                    method.invoke(theInterface, args);
                    System.out.println(222);
                    return null;
                }
                return method.invoke(theInterface, args);
            }
        });

        proxiedInterface.method();
    }
}
