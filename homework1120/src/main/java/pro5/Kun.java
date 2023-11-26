package pro5;

/**
 * @author liu
 * @date 2023/11/21 11:07
 */
public class Kun extends Thread{


    private pro5.Basket basket;
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