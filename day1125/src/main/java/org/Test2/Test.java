package org.Test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**Method 方法的反射对象
 *
 * @author liu
 * @date 2023/11/25 10:43
 */
public class Test {
    public static void main(String[] args)throws Exception {
        //借助反射，获取相关的sell反射对象
        //并最终调用sell方法
        Class pClass = Class.forName("org.Test2.Product");
        Constructor<Product> c = pClass.getConstructor();
        Product p =c.newInstance();
        Method setIdMethod = pClass.getMethod("setId",Integer.class);
        Method setNameMethod = pClass.getMethod("setName",String.class);
        Method setPriceMethod = pClass.getMethod("setPrice",float.class);
        setIdMethod.invoke(p,1);
        setNameMethod.invoke(p,"眉笔");
        setIdMethod.invoke(p,79.0f);
        Method sellMethod = pClass.getMethod("sell");
        sellMethod.invoke(p);
    }
}
