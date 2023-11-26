package org;

/**
 * @author liu
 * @date 2023/11/19 11:14
 */

public class ClassTest2 extends Thread{
    private int id;

    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassTest2(){
        super();
    }

    @Override
    public void run(){

    }
    public static void main(String[] args) {


    }
}
