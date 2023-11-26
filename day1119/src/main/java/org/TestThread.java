package org;

/**
 * @author liu
 * @date 2023/11/19 9:23
 */
public class TestThread {
    public static void main(String[] args) {
        //通过Runnable接口完成线程对象实例化的时候
        //需要通过Thread完成实例化
//        FuckRice fr1 = new FuckRice();
//        Thread t1 = new Thread(fr1);
//        FuckRice fr2 = new FuckRice();
//        Thread t2 = new Thread(fr2);
//        t1.setName("1");
//        t2.setName("2");
//        t1.start();
//        t2.start();
        //匿名内部类 本身是内部类的一种
        //只不过不需要开发者提供类的名称 类名
        //由jvm动态分配
        Thread t1 =new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我要启动，我是："+this.getName());
                }
            }
        };
        t1.setName("1");
        Thread t2 =new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我不要启动，我是："+this.getName());
                }
            }
        };
        t2.setName("2");
        t1.start();
        t2.start();
        System.out.println(t1.getClass());
        System.out.println(t2.getClass());
    }
}
