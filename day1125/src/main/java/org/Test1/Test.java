package org.Test1;

import java.io.*;
import java.lang.reflect.Constructor;

/**在反射的思想中 万物全是对象
 * 构造方法 方法 成员变量 都可以当对象使用 必须用类对象获取
 * 配置优于是实现 约定优于实现
 * @author liu
 * @date 2023/11/25 9:16
 */
public class Test {
    public static Person getInstance(String ssname) throws Exception {
        File f = new File("E:\\idea_work\\homework11-16\\day1125\\src\\main\\java\\org\\Test1\\person.config");
        FileInputStream fis = new FileInputStream(f);
        String line;
        String sname ="";
        byte[] all = new byte[2000];
       line = String.valueOf(fis.read(all));
            int j =0;
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i)=='='){
                    j=i;
                }
            }
            char[] name =new char[2000];
            for (int i = j; i <line.length() ; i++) {
                int k =i-j;
                name[k]=line.charAt(i);
            }
            sname = String.copyValueOf(name);
        Class c4 = Class.forName(sname);
        Constructor<Student> cc1 = c4.getConstructor(String.class);
        Student ss1 =cc1.newInstance(ssname);
        ss1.eat();
        return ss1;
    }
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("org.Test1.Student");
        Constructor<Student> c =c1.getConstructor();
        Student s = c.newInstance();
        System.out.println(s);
        //获取有参构造函数的过程对象
        Constructor<Student> cc = c1.getConstructor(String.class);
        //利用有参构造函数完成对象的创建
        Student s1= cc.newInstance("lyd");
        System.out.println(s1);
        getInstance("sxl");

    }

}
