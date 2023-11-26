package pro1;

/**
 * @author liu
 * @date 2023/11/20 18:09
 */
public class Threadpro3 extends Thread{
    private String name;
    private UseList useList;
    public Threadpro3(String name, UseList useList) {
        this.name = name;
        this.useList=useList;
    }
    @Override
    public void run() {
        ListPool listPool = useList.getList();
        if (listPool==null){
            System.out.println(name+"没有取出数据");
        }else {
            System.out.println(name+"取出了数据"+listPool.getNum());
        }
    }
}
