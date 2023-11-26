package testparer;

/**
 * @author liu
 * @date 2023/11/1616:37
 */
public class Pro2  {
    public void test(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i+1; j++) {
                System.out.print(i+"+"+j+"="+i*j +"\t");
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        Pro2 p = new Pro2();
        p.test();
    }


}
