package code1.proxy.staticProxy;

public class StaticProxyTest {
    public static void main(String[] args) {
//        SuperInterface superInterface = new BeProxied();
//        superInterface.method();
        SuperInterface superInterface = new StaticProxy();
        superInterface.method();
    }
}
