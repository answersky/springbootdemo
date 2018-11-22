package com.answer.demo.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * created by liufeng
 * 2018/11/22
 */
public class WriteTest {
    public static void main(String[] args) {
        File file=new File("D:\\myspace\\springbootdemo\\src\\main\\java\\com\\answer\\demo\\io\\read.txt");
        FileWriter writer=null;
        try {
            //覆盖写入 是否追加 true
            writer=new FileWriter(file,true);
            writer.write("123");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer!=null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
