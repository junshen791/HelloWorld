package org;

/**线程的休眠 sleep
 * sleep会使当前线程暂停运行并放弃jvm的调度资源
 * 其他线程可以在该线程的调sleep时间内获取jvm的调度
 * 线程可以指定sleep时间 时间到了之后 线程会恢复
 * @author liu
 * @date 2023/11/19 9:43
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
              int times = 0;
              while (true){
                  System.out.println("休眠");
                  try {
                      Thread.sleep(10);
                      System.out.println("休眠结束");

                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
                  times+=0.01;
                  System.out.println("运行时间"+times);

              }
            }
        };
        Thread t2 =new Thread() {
            @Override
            public void run() {
              while (true){
                  System.out.println("t2调度");
              }
            }
        };
        t1.start();
        t2.start();
        }





}
