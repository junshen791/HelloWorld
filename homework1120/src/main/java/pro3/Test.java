package pro3;

/**
 * @author liu
 * @date 2023/11/21 10:19
 */
public class Test {
        public static void main(String[] args) {
            Basket basket = new Basket();
            Kun kun = new Kun(basket);
            kun.start();
            for (int i = 0; i < 10; i++) {
               Ikun  ikun = new Ikun(basket);
                ikun.start();
            }
        }
}
