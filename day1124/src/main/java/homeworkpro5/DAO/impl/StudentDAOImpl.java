package homeworkpro5.DAO.impl;

import homeworkpro5.DAO.StudentDAO;
import homeworkpro5.DBUtil;
import homeworkpro5.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/25 0:55
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void insert(Student student) {
        String sql = "insert into student(name,gender,birthday,address,qqnumber) " +
                "values(?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            // 使用方法进行传参 用序号代表所传递参数问号的位置 这里是java中为数不多基1的参数传递
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setString(4, student.getAddress());
            ps.setLong(5, student.getQqnumber());
            ps.execute();
            // 在执行完插入语句之后 mysql会为新增的数据分配一个自增长id
            // jdbc可以通过getGeneratedKeys方法获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                student.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id = " + id;
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement();
        ) {
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name = ?,gender = ?,birthday = ?,address = ?,qqnumber = ? where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setString(4, student.getAddress());
            ps.setLong(5, student.getQqnumber());
            ps.setInt(6, student.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Student> listAll() {
        return listByPage(null, 0, Integer.MAX_VALUE);
    }
    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> stus = new ArrayList<>();
        String sql;
        if (key == null || key == "") {
            sql = "select * from student limit ?,?";
        } else {
            sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        }
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            if (key == null || key == "") {
                ps.setInt(1, start);
                ps.setInt(2, count);
            } else {
                ps.setString(1, key);
                ps.setInt(2, start);
                ps.setInt(3, count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                // 从结果集遍历的当前行中 将每一个字段的值单独取出
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Long qqnumber = rs.getLong("qqnumber");
                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                s.setAddress(address);
                s.setQqnumber(qqnumber);
                stus.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stus.isEmpty() ? null : stus;
    }
}
