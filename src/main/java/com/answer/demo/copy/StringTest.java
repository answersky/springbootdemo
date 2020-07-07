package com.answer.demo.copy;

/**
 * created by liufeng
 * 2020/7/7
 *
 */
public class StringTest {
    /**
     * string 编译期最大长度限制是65535
     * 运行期  最大长度是Integer的最大长度
     * @param args
     */
    public static void main(String[] args) {
        String s="";
        for(int i=0;i<100000;i++){
            s=s+"1";
        }
        System.out.println(s);
    }
}
