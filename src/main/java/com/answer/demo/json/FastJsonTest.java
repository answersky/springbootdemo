package com.answer.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;

/**
 * created by liufeng
 * 2021/9/24
 * FastJSON ＜= 1.2.68 存在漏洞
 */
public class FastJsonTest {

    public static void main(String[] args) throws IOException {
        StringBuffer Buffer = new StringBuffer();
        //D:\workspace\springbootdemo\src\main\java\com\answer\demo\json\demo
        FastJsonTest.readToBuffer(Buffer, "D:\\workspace\\springbootdemo\\src\\main\\java\\com\\answer\\demo\\json\\demo");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        Object obj = JSON.parseObject(Buffer.toString());
//        Object obj = JSON.parse(Buffer.toString());
        System.out.println(obj);

//        MyJson json=new MyJson();
//        json.setAge("12");
//        json.setName("2222");
//        System.out.println(JSON.toJSONString(json,SerializerFeature.WriteClassName));
    }

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }
}
