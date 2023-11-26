package test.DAO;

import java.util.List;

/**
 * @author liu
 * @date 2023/11/17 9:31
 */
public interface User {
    void register(test.entity.User var1);
    List<User> login(String username,String password);
}
