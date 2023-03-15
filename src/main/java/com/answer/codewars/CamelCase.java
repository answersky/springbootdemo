package com.answer.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/7/22
 */
public class CamelCase {
    public static void main(String[] args) {
        assertEquals("TestCase", camelCase("test case"));
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
        assertEquals("SayHello", camelCase("say hello "));
        assertEquals("Z", camelCase("z"));
        assertEquals("AbC", camelCase("ab  c"));
        assertEquals("", camelCase(""));
    }

    private static String camelCase(String str) {
        if(str==null || "".equals(str)){
            return str;
        }
        StringBuffer sb=new StringBuffer();
        String[] strings=str.split(" ");
        for(String ch:strings){
            if(!" ".equals(ch) && !"".equals(ch)){
                char[] chars=ch.toCharArray();
                String first=String.valueOf(chars[0]).toUpperCase();
                sb.append(first);
                if(chars.length>1){
                    for(int i=1;i<chars.length;i++){
                        sb.append(chars[i]);
                    }
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
