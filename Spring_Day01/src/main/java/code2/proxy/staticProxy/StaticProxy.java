package code2.proxy.staticProxy;

public class StaticProxy implements TheInterface {
    private TheInterface theInterface;

    public StaticProxy(TheInterface theInterface) {
        this.theInterface = theInterface;
    }

    public void method() {
        theInterface.method();
        System.out.println(222);
    }
}
