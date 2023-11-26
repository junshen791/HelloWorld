package org.pro3;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
/**反射核心体现在spring
 * IOC 控制反转
 * DI 依赖注入
 * @author liu
 * @date 2023/11/25 10:59
 */
public class Test {
    public static void main(String[] args)throws Exception {
        //从配置文件中提取所需要的信息
        File springConfigFile = new File("E:/idea_work/homework11-16/day1125/src/main/java/org/pro3/spring.properfies");
        //使用java提供的Properties类
        Properties springConfig =new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        String className = (String)springConfig.get("className");
        String methodName = (String)springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserService> c = uClass.getConstructor();
        m.invoke(c.newInstance());
    }
}
