package homeworkpro3;

/**
 * @author liu
 * @date 2023/11/25 23:27
 */
public class Test {
    private static synchronized void printA(){
        System.out.println("A");
    }
    private static synchronized void printB(){
        System.out.println("B");
    }
    private static boolean choose = false;
   private static String o="lock";
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t1 =new Thread(){
                @Override
                public void run() {
                    synchronized (o){
                        while (choose) {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        printA();
                        choose = true;
                        o.notifyAll();
                    }
                }
            };
            t1.start();
            Thread t2 =new Thread(){
                @Override
                public void run() {
                    synchronized (o){
                        while (!choose) {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        printB();
                        choose = false;
                        o.notifyAll();
                    }

                }
            };
            t2.start();
        }


    }
}
