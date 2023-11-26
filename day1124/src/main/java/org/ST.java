package org;

/**在类加载的时候，就已经完成了对象的初始化
 * 不存在线程安全问题
 * @author liu
 * @date 2023/11/24 14:20
 */
public class ST {
    private static ST st = new ST();
    private ST(){}
    public ST getSt(){
        return st;
    }
}
