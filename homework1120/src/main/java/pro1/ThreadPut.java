package pro1;

/**
 * @author liu
 * @date 2023/11/20 18:56
 */
public class ThreadPut extends Thread{
    private String name;
    private UseList useList;
    public ThreadPut(String name, UseList useList) {
        this.name = name;
        this.useList=useList;
    }
    @Override
    public void run() {
        Boolean bool1 = useList.putList(new ListPool());
        if (!bool1){
            System.out.println(name+"没有加入数据");
        }else {
            System.out.println(name+"加入了数据");
        }
    }
}
