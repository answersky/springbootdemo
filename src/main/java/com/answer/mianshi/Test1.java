package com.answer.mianshi;

/**
 * created by liufeng
 * 2020/11/26
 */
public class Test1 {
    public static void main(String[] args) {
        function(5);
    }

    private static void function(int k){
        if(k>0){
            function(k-1);
        }
        System.out.println(k);
    }
}
