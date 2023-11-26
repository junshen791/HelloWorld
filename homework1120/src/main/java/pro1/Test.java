package pro1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/20 19:01
 */
public class Test {
    public static void main(String[] args) {
        UseList useList = new UseList();
        List<Threadpro3> littleBlack = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Threadpro3 threadpro3 = new Threadpro3("thread"+(i+1),useList);
            littleBlack.add(threadpro3);
        }
        for (Threadpro3 threadpro3:littleBlack) {
            threadpro3.start();
        }
        List<ThreadPut> l= new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ThreadPut threadPut = new ThreadPut("thread"+(i+1),useList);
            l.add(threadPut);
        }
        for (Threadpro3 threadpro3:littleBlack) {
            threadpro3.start();
        }

    }
}
