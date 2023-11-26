package homeworkpro5.DAO;

import homeworkpro5.Student;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/25 0:50
 */
public interface StudentDAO {
    void insert(Student student);
    void delete(Integer id);
    void update(Student student);
    List<Student> listAll();
    List<Student> listByPage(String key, Integer start, Integer count);
}
