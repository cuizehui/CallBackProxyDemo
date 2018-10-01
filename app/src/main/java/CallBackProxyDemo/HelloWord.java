package CallBackProxyDemo;


public class HelloWord implements SayHello {

    HelloWordCallBack hellowordCallBack;

    public void addCallBack(HelloWordCallBack hellowordCallBack){
        this.hellowordCallBack=hellowordCallBack;
    }
    @Override
    public void sayHello(String s, int i) {
        System.out.println("sayHello:"+s+" "+i);
        if(hellowordCallBack!=null){
            hellowordCallBack.onHelloWord(s,i);
        }
    }
}
