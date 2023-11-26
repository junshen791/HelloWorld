package MOTA;

/**
 * @author liu
 * @date 2023/11/19 15:22
 */
public class Test4 {
    public static void main(String[] args) {
        final Object o1= new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("t1线程运行了");
                System.out.println("t1试图获取o对象的锁");
                synchronized (o1){
                    System.out.println("t1获取了o1对象的锁");
                    System.out.println("t1试图获取o2对象的锁");
                    System.out.println("t1被堵塞");
                    synchronized (o2){
                        System.out.println("t1获取到o2");
                    }
                }
                System.out.println("线程t1运行结束");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("t2线程运行了");
                System.out.println("t2试图获取o对象的锁");
                synchronized (o2){
                    System.out.println("t2获取了o2对象的锁");
                   System.out.println("t2试图获取o1对象的锁");
                    System.out.println("t2被堵塞");
                    synchronized (o1){
                        System.out.println("t2获取到o1");
                    }
                }
                System.out.println("线程t2运行结束");
            }
        };
        t1.start();
        t2.start();
    }
}
