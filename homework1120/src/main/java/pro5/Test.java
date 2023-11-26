package pro5;


/**
 * @author liu
 * @date 2023/11/21 11:08
 */
public class Test {
    public static void main(String[] args) {
        pro5.Basket basket = new Basket();
        for (int i = 0; i < 10; i++) {
            pro5.Kun kun = new Kun(basket);
            kun.start();
        }

        for (int i = 0; i < 10; i++) {
            Ikun ikun = new Ikun(basket);
            ikun.start();
        }
    }


}
