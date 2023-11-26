package MOTA;

/**
 * @author liu
 * @date 2023/11/19 15:44
 */
public class Test3 {
    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
