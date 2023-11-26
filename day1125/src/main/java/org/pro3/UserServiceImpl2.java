package org.pro3;

/**
 * @author liu
 * @date 2023/11/25 11:04
 */
public class UserServiceImpl2 implements UserService{
    @Override
    public void login() {
        System.out.println("扫码登录");
    }

    @Override
    public void register() {
        System.out.println("第三方账户注册");
    }
}
