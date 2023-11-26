package org;

/**join main 方法对应的主线程 在一开始的时候
 * 一定是先运行的 只有主线程运行了 其他线程才会被实例化
 * 才会进入就绪状态
 * @author liu
 * @date 2023/11/19 9:53
 */
public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t1");
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t2");
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //代码执行到这一行时，一定是主线程在运行
            //当t1join了主线程后，只有当t1线程运行之后运行之后
            //主线程才会继续执行
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t3");
                }
            }
        };
        t3.start();
    }

}
