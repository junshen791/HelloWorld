package org.pro1;

import java.util.concurrent.Callable;

/**反射 和注解
 * 将java的类当作是一种对象 叫类对象
 * 所属的类 Class
 * @author liu
 * @date 2023/11/25 9:03
 */
public class Test {
    static {
        System.out.println("静态属性被加载");
    }
    public static void main(String[] args) throws Exception {
        //获取类的类对象
        //1.调用class.forname 获取
        Class c1 = Class.forName("org.pro1.Test");
        //2.利用类对象对应的类的实例获取
        Class c2 = new Test().getClass();
        //3.使用。class直接获取
        Class c3 = Test.class;
        System.out.println(c1==c2);
        System.out.println(c2==c3);
        //类对象获取的时候会自动加载静态变量
        //.class方式获取类信息的时候，不会加载类的静态属性

    }

}
