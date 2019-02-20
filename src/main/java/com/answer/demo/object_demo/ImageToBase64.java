package com.answer.demo.object_demo;

import sun.misc.BASE64Encoder;

/**
 * created by liufeng
 * 2019/2/19
 */
public class ImageToBase64 {
    public static void main(String[] args) {
        String imgFile="D:\\img\\22.jpg";
        /*InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String url="img/201501/28/20150128132252867.jpg?x-oss-process=image/resize,P_80";
        byte[] data=url.getBytes();
        String base64Str=safeUrlBase64Encode(data);
        System.out.println(base64Str);

        test("//img/201512/02/2015120209341613.jpg");
    }

    public static String safeUrlBase64Encode(byte[] data){

        String encodeBase64 = new BASE64Encoder().encode(data);

        String safeBase64Str = encodeBase64.replace('+', '-');

        safeBase64Str = safeBase64Str.replace('/', '_');

        safeBase64Str = safeBase64Str.replaceAll("=", "");

        return safeBase64Str;

    }

    private static void test(String productImg){
        int len = productImg.length();
        int index = 0;
        char strs[] = productImg.toCharArray();
        for(int i=0; i<len; i++){
            if('/'!=strs[i]){
                index=i;
                break;
            }
        }
        String strLast = productImg.substring(index, len);
        System.out.println(strLast);
    }
}

