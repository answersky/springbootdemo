package com.answer.demo.barcode;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;

/**
 * @author liufeng
 * 2021/11/8 15:43
 * 条形码
 */
public class Barcode {
    private final static List<String> specialCodes= Lists.newArrayList("&","#","_");

    /**
     * 生成文件
     *
     * @param msg
     * @param path
     * @return
     */
    public static File generateFile(String msg, String path) {
        File file = new File(path);
        try {
            generate(msg, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    /**
     * 生成字节
     *
     * @param msg
     * @return
     */
    public static byte[] generate(String msg) {
        String code=specialCodeEnode(msg);
        System.out.println("特殊符号处理："+code);
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(code, ous);
        return ous.toByteArray();
    }

    /**
     * 生成到流
     *
     * @param msg
     * @param ous
     */
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }

        Code39Bean bean = new Code39Bean();

        // 精细度
        final int dpi = 150;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.0f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        String format = "image/png";
        try {

            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getImgStr(String imgFile) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(data);
    }

    private static String specialCodeEnode(String msg){
        String str=msg;
        for(String code:specialCodes){
            if(msg.contains(code)){
                int index=msg.indexOf(code);
                char[] chars=msg.toCharArray();
                String specialCode=String.valueOf(chars[index]);
                String newCode= URLEncoder.encode(specialCode);
                str=str.replace(specialCode,newCode);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String msg = "moond214";
//        String path = "barcode.png";
//        generateFile(msg, path);
//        System.out.println("data:image/png;base64,"+getImgStr(path));
        byte[] bytes=generate("33332222&#-");
        System.out.println("data:image/png;base64,"+Base64.getEncoder().encodeToString(bytes));
    }
}
