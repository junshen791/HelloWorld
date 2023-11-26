package homeworkpro2;

/**
 * @author liu
 * @date 2023/11/25 23:04
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"启动");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"关闭");
                }
            };
            t.start();
        }
    }
}
