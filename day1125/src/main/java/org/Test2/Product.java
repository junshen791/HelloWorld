package org.Test2;

/**
 * @author liu
 * @date 2023/11/25 10:43
 */
public class Product {
    private Integer id;
    private String name;
    private Float price;
    public void sell(){
        System.out.println(name+"商品大甩卖，原价："+price+",现价只要"+price/2);
    }
}
