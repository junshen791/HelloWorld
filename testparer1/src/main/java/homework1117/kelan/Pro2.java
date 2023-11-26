package homework1117.kelan;

/**
 * @author liu
 * @date 2023/11/17 19:43
 */
public class Pro2 {
    public void test(){
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i!=j&&i!=k&&j!=k){
                        int temp = i*100+j*10+k;
                        System.out.println(temp);
                    }
                }

            }

        }
    }
}
