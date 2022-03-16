package com.answer.mianshi;

import com.google.gson.JsonObject;

/**
 * @author liufeng
 * 2022/2/9 11:54
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "ab";
        String c = a + "c";
        String d = "abc";
        System.out.println(d == c);
        System.out.println(d.equals(c));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "ssss");
        jsonObject.addProperty("age", 23);
        System.out.println(jsonObject.toString());
    }
}
