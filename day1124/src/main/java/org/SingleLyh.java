package org;

/**  双重检查锁的单例模式
 * @author liu
 * @date 2023/11/24 14:28
 */

public class SingleLyh {
    private volatile static SingleLyh singleLyh;
    private SingleLyh(){}
    public static SingleLyh getInstance(){
        if(singleLyh == null){
            synchronized (SingleLyh.class){
                if (singleLyh == null){
                    singleLyh = new SingleLyh();
                }
            }
        }
        return singleLyh;
    }
}