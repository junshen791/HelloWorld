package homework1117.zhongke;

/**
 * @author liu
 * @date 2023/11/18 23:23
 */
public class Test {
    public static void main(String[] args) {
        String[][] s =new String[5][];
        try {
            s[4]=new String[3];
            s[4][1]="hello";
        } catch (ArrayIndexOutOfBoundsException e2){
            System.out.println("数组下标越界");
        } catch (Exception e){
            System.out.println("异常发生");
        }
    }
}
