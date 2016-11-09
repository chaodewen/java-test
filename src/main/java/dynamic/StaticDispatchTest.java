package dynamic;

/**
 * Created by Dewayne on 2016/11/2.
 */

public class StaticDispatchTest {
    static abstract class Human {}
    static class Man extends Human {}
    static class Woman extends Human {}
    public void sayHello(Human guy) {
        System.out.println("Human!");
    }
    public void sayHello(Man guy) {
        System.out.println("Man!");
    }
    public void sayHello(Woman guy) {
        System.out.println("Woman!");
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatchTest sdt = new StaticDispatchTest();
        sdt.sayHello(man);
        sdt.sayHello(woman);
    }
}