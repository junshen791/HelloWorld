package org;

/** 线程的优先级 优先级高的会有更大的概率竞争到jvm资源
 * 但是高优先级不代表绝对 只是相对几率更大
 * 线程的优先级必须在线程进入就绪之前设置好
 * @author liu
 * @date 2023/11/19 10:27
 */
public class TestThread3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName());
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName());
                }
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(1);
        t1.setPriority(10);
        t1.start();
        t2.start();

    }
}
