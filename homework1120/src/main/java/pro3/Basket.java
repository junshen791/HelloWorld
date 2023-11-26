package pro3;

/**
 * @author liu
 * @date 2023/11/21 10:37
 */
public class Basket {
        private final int capacity = 10;
        private int eggCount = 0;
        synchronized void putEgg() {
            while (eggCount == capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            eggCount++;
            System.out.println("Kun 下了一个蛋，篮子里现在有 " + eggCount + " 个蛋");
            notifyAll();
        }
        synchronized void getEgg() {
            while (eggCount == 0) {
                try {
                    wait(); // 等待篮子不空
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            eggCount--;
            System.out.println("小黑子取了一个蛋，篮子里还剩 " + eggCount + " 个蛋");
            notifyAll();
        }

}
