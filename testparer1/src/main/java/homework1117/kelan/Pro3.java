package homework1117.kelan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @date 2023/11/17 19:49
 */
public class Pro3 {
    public static void main(String[] args) {
        Map<String,String> h = new HashMap<>();
        h.put("name","joy");
        h.put("age","30");
        h.put("address","room 1802");
        h.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
     
    }
}
