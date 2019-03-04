package com.answer.demo.object_demo;

import com.gangling.middleware.file.FileUtils;
import com.gangling.middleware.file.interf.UploadResult;

import java.io.File;

/**
 * created by liufeng
 * 2019/2/20
 */
public class ImgToOss {
   /*
   */
   private static final String path = "img/buyTogether";  //指定文件路径，若不存在则创建
    private static final String fileName = "app-bg.jpg"; //指定文件名，若为空则采用实际文件名(Desert.jpg)
    private static final String actualFileName = "D:\\img\\app-bg.jpg"; //本地文件名

    public static void main(String[] args) {
        File file = new File(actualFileName);
        UploadResult rs = FileUtils.uploadFile(file, path, fileName);
        System.out.println(rs);
    }
}
