package MOTA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liu
 * @date 2023/11/19 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster {

    private String name;
    private float hp;
    public synchronized void recover(){
        hp++;
        System.out.println("为："+name+"恢复了一点生命值，当前血量"+hp);
        this.notify();
    }
    public synchronized void hurt() {
        if (hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp--;
        System.out.println("扣血，当前血量"+hp);
    }

}
