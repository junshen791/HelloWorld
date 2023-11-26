package pro3;

/**
 * @author liu
 * @date 2023/11/21 10:36
 */
public class Kun extends Thread{


private Basket basket;
     Kun(Basket basket) {
            this.basket = basket;
        }

        @Override
        public void run() {
            while (true) {
                basket.putEgg();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
