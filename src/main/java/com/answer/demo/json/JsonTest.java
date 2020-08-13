package com.answer.demo.json;

import com.google.gson.JsonObject;
import net.sf.json.JSON;

/**
 * created by liufeng
 * 2020/7/21
 */
public class JsonTest {
    public static void main(String[] args) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("msgtype","text");
        JsonObject object=new JsonObject();
        object.addProperty("content","hello word");
        jsonObject.addProperty("text",object.toString());
        System.out.println(jsonObject.toString());
    }
}
