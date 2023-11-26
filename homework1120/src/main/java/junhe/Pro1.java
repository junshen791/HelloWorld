package junhe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liu
 * @date 2023/11/21 21:09
 */
public class Pro1 {
    public int test(int number){
        String str = Integer.toString(number);
        Set<Character> char1 = new HashSet<>();
        for (int i = str.length()-1; i >= 0; i--) {
            char temp = str.charAt(i);
            char1.add(temp);

        }
        int returnNum = 0;
        for (char temp:
             char1) {
            returnNum=returnNum*10+(temp-'0');
        }
        return returnNum;
    }
    public static void main(String[] args) {
        Pro1 p = new Pro1();
        System.out.println("请输入数字");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(p.test(num));

    }
}

