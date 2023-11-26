package pro5;

/**
 * @author liu
 * @date 2023/11/21 11:03
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
        System.out.println("npc发布了 " + eggCount + " 个任务");
        notifyAll();
    }
    synchronized void getEgg() {
        while (eggCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        eggCount--;
        System.out.println("玩家接了 " + eggCount + " 个任务");
        notifyAll();
    }

}
