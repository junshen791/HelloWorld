package test.DAO;

import test.DBUtil;
import test.entity.User;

import java.sql.*;

/**
 * @author liu
 * @date 2023/11/17 9:36
 */
public class UserDAOImpl {
    private static UserDAOImpl userDAO = new UserDAOImpl();
    public UserDAOImpl() {}
    public void register(User user) {
        if (isUsernameExists(user.getUsername())) {
            System.out.println("用户已经存在");
        }
        String sql = "insert into User(username,password) values(?,?) ";

        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1,user.getUsername() );
            ps.setString(2,user.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static boolean isUsernameExists(String username) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM User WHERE username = ?");
        ) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
