package org.pro5;

import java.lang.annotation.*;

/**@Target() 表示代码能用于那个位置
 * @author liu
 * @date 2023/11/25 14:04
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//@Repeatable 1.8新增的注解 表示当前同一个位置，注解可以出现多次
@SuppressWarnings("all")
public @interface JDBCConfig {
    String url();
    String username();
    String password();

}
