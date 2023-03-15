package com.answer.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/2/28
 */
public class Kata {
    public static void main(String[] args) {
//        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
//        assertEquals("elppa", reverseWords("apple"));
//        assertEquals("a b c d", reverseWords("a b c d"));
//        assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
        assertEquals("   ", reverseWords("   "));
    }

    private static String reverseWords(final String original) {
        String result="";
        String[] arr=original.split(" ");
        if(arr.length==0){
            //全部是空格
            return original;
        }
        for(int k=0;k<arr.length;k++){
            char[] strings=arr[k].toCharArray();
            for(int i=strings.length-1;i>=0;i--){
                result=result+String.valueOf(strings[i]);
            }
            if(k<arr.length-1){
                result=result+" ";
            }
        }

        System.out.println(result);
        return result;
    }
}
