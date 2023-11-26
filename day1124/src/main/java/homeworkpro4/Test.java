package homeworkpro4;

/**
 * @author liu
 * @date 2023/11/25 0:26
 */
public class Test {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("线程一获取锁一");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){e.printStackTrace();}
                    System.out.println("线程一试图获取锁2");
                    synchronized (lock2) {
                        System.out.println("你怎么进来的");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("线程二获取锁耳");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程二试图获取锁1");
                    synchronized (lock1) {
                        System.out.println("你怎么进来的");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
