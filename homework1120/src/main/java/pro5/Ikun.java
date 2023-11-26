package pro5;

/**
 * @author liu
 * @date 2023/11/21 11:06
 */
class Ikun extends Thread {

    private pro5.Basket basket;

    Ikun(Basket basket) {
        this.basket = basket;
    }
    @Override
    public void run() {
        while (true) {
            basket.getEgg();
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
