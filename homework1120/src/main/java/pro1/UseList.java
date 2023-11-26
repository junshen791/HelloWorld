package pro1;

import java.util.LinkedList;

/**
 * @author liu
 * @date 2023/11/20 18:21
 */
public class UseList {
    private LinkedList<ListPool> poolList;

    public UseList() {
        poolList = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            poolList.add(new ListPool(i + 1));
        }
    }
    public  ListPool getList() {

        synchronized (this){
            if(poolList.isEmpty()){
                return null;
            }
            return poolList.removeLast();
        }
    }
    public  Boolean putList(ListPool listPool) {
        synchronized (this){
            if(poolList.size()>=30){
                return false;
            }
            poolList.add(listPool);
            return true;
        }
    }

}
