package CallBackProxyDemo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloWordCallBackProxy implements InvocationHandler, HelloWordCallBackProxyMethod {

    private Object tar;

    //绑定委托对象，并返回代理类
    public Object bind(Object tar) {
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        startHellWordProxy();
        System.out.println("Start Proxy");
        for (int i = 0; i < args.length; i++) {
            System.out.println("helloWord Proxy  arg" + i + ":" + args[i].toString());
        }
        endHelloWordProxy();
        result = method.invoke(tar, args);
        //在调用具体函数方法后，执行功能处理
        return result;
    }

    @Override
    public void startHellWordProxy() {
        System.out.println("startHellWordProxy" + "Start Proxy");
    }

    @Override
    public void endHelloWordProxy() {
        System.out.println("endHelloWordProxy" + "Start Proxy");
    }
}
