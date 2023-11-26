package org;

/** 多线程
 * 1.继承Thread类
 * 2.实现Runnable
 * 区别 thread是继承 Runnable是接口 拓展性更好
 * 3.实现Callable接口（了解）
 * 4.实现Future接口（了解）
 *
 * @author liu
 * @date 2023/11/19 8:48
 */

public class FightRice extends Thread{
    public FightRice(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("要吃饭"+this.getName());
        }
    }
}
