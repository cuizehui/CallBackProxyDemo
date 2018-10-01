package CallBackProxyDemo;


public class HelloWordCallBackImpl implements HelloWordCallBack {
    @Override
    public void onHelloWord(String s, int o) {
        System.out.println("HelloWord callback : "+s+" "+o);
    }
}
