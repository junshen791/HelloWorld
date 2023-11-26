package homework1117.kelan;

/**
 * @author liu
 * @date 2023/11/17 18:47
 */
public class Pro1 {
    public double seq(double n){
        if (n==1)
        {return 1;}
        if (n==2)
        {return 2;}
        return seq(n-1)+seq(n-2);
    };
    public double test(int n){
        if (n==1){return  seq(2)/seq(1);}
        return test(n-1)+seq(n+1)/seq(n);
    }
    public static void main(String[] args) {
        Pro1 p =new Pro1();
        System.out.println(p.test(20));
    }
}
