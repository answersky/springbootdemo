package com.answer.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/4/3
 */
public class Dubstep {
    public static void main(String[] args) {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }

    public static String SongDecoder (String song) {
        if(song==null || "".equals(song)){
            return "";
        }
        String[] arr=song.split("WUB");
        String result="";
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(!"".equals(arr[i])){
                result=result+" "+arr[i];
            }
        }
        return result.trim();
    }
}
