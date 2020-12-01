package code1.proxy.staticProxy;

public class StaticProxy implements SuperInterface {
    private BeStaticallyProxied beStaticallyProxied = new BeStaticallyProxied();

    public void method() {
        beStaticallyProxied.method();
        System.out.println(222);
    }
}
