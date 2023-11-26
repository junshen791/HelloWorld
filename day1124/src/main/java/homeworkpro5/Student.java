package homeworkpro5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author liu
 * @date 2023/11/25 0:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
        private Integer id;
        private String name;
        private String gender;
        private Date birthday;
        private String address;
        private Long qqnumber;

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", birthday=" + birthday +
                    ", address='" + address + '\'' +
                    ", qqnumber=" + qqnumber +
                    "}\r\n";
        }


}
