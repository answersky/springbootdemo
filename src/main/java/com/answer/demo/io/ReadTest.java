package com.answer.demo.io;

import java.io.*;

/**
 * created by liufeng
 * 2018/11/22
 */
public class ReadTest {
    public static void main(String[] args) {
        File file=new File("D:\\myspace\\springbootdemo\\src\\main\\java\\com\\answer\\demo\\io\\read.txt");
        BufferedReader read=null;
        try {
            read=new BufferedReader(new FileReader(file));
//            while (read.read()!=-1){//当前判断条件已经读了第一个字符
//                System.out.println((char)read.read());//这是读取了第二个字符  打印2
//                String str=read.readLine(); //读完剩下的字符
//                System.out.println(str);
//            }
            do{
                System.out.println((char)(read.read())); //读取第一个字符  打印1
                String s =read.readLine(); //读取剩下字符
                System.out.println(s);
            }while(read.read()!=-1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(read!=null){
                    read.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
