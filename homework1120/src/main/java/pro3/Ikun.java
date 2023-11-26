package pro3;

/**
 * @author liu
 * @date 2023/11/21 10:20
 */
class Ikun extends Thread {
        private Basket basket;
        Ikun(Basket basket) {
            this.basket = basket;
        }
    @Override
    public void run() {
        while (true) {
            basket.getEgg();
            try{
                sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}