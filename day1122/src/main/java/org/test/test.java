package org.test;

import org.junit.Test;

/**
 * @author liu
 * @date 2023/11/22 18:31
 */
public class test {
    //静态方法的同步对象是当前类所对应的class对象
    public synchronized static void li(){

    }
    //每一个类的反射  对象全局唯一
    public static void l(){
        synchronized (Test.class){

        }
    }
}
