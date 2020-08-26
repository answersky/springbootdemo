package com.answer.demo.serialize;

import java.io.*;

/**
 * created by liufeng
 * 2020/8/21
 */
public class SerializeTest {
    /**
     * 如果SerializeClass未实现序列化，则不能正常写入文件
     * 实现序列化接口实际上只是一个标识（查看源码可查）
     *
     * 反序列化的时候会判断serialVersionUID是否一致，如果不一致则不能反序列化成功
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试序列化
        //1先通过流写入文件
        SerializeClass serializeClass=new SerializeClass();
        serializeClass.setId(1);
        serializeClass.setName("aaaa");
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D:\\myworkspace\\springbootdemo\\src\\main\\java\\com\\answer\\demo\\serialize\\wenben.txt"));
        outputStream.writeObject(serializeClass);

        //通过流读出对象
        ObjectInputStream inputStream=new ObjectInputStream((new FileInputStream("D:\\myworkspace\\springbootdemo\\src\\main\\java\\com\\answer\\demo\\serialize\\wenben.txt")));
        SerializeClass sc= (SerializeClass) inputStream.readObject();
        System.out.println(sc);
    }
}
