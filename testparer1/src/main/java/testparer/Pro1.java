package testparer;

/**
 * @author liu
 * @date 2023/11/16 16:31
 */
public class Pro1 {
    public void test(){
        for (int i = 1; i <5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k <5; k++) {
                    if (i!=j&&j!=k&&k!=i){
                        int temp =100*i+10*j+k;
                        System.out.println(temp);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Pro1 pro1 = new Pro1();
        pro1.test();
    }

}
