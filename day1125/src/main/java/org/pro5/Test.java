package org.pro5;

/**注解 @Override
 * 注解类类似于标签纸模板 决定了能有那些属性
 * 注解必须结合代码才有实际意义
 * 注解本身也是一个类
 * @Override
 * @Deprecated 表示方法未来会被淘汰
 * @SuppressWarnings 警告抑制
 * deprecation 使用不赞成使用的类和语言的警告
 * unchecked 使用了未检查的转换的警告
 * fallthrough switch代码块没有写break时的警告
 * path 类和源文件不存在时的警告
 * serial 当在可序列化的类上减少serialVersionUID时候的警告
 * rawtypes 泛型类型未指明
 * unused 定义了引用，但是没有声明
 * all 以上所有
 * @FunctionInterface 可以添加函数式接口
 * @author liu
 * @date 2023/11/25 13:46
 */
@SuppressWarnings("all")
public class Test {
    @Deprecated
    public static void run(){
    }
     public void run1(){
    System.out.println(" ");
}

    public static void main(String[] args) {
        run();
    }
}
