package org.pro3;

/**
 * @author liu
 * @date 2023/11/25 11:03
 */
public class UserService1 implements UserService{
    @Override
    public void login() {
        System.out.println("密码登录");
    }

    @Override
    public void register() {
        System.out.println("密码注册");
    }
}
