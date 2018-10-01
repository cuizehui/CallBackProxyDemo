package CallBackProxyDemo;


public class Test {

    public static void main(String[] args) {
        HelloWord helloword = new HelloWord();
        HelloWordCallBackImpl hellowordCallBackImpl = new HelloWordCallBackImpl();
        HelloWordCallBackProxy helloWordCallBackProxy = new HelloWordCallBackProxy();
        HelloWordCallBack callback = (HelloWordCallBack) helloWordCallBackProxy.bind(hellowordCallBackImpl);
        helloword.addCallBack(callback);
        helloword.sayHello("hello", 123);
    }
}
