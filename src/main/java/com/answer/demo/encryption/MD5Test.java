package com.answer.demo.encryption;

import cn.hutool.crypto.SecureUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * created by liufeng
 * 2018/11/29
 */
public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest=MessageDigest.getInstance("md5");
        byte[] encrypStr=messageDigest.digest("answer".getBytes("utf-8"));
        System.out.println("加密后："+convertToHexString(encrypStr));

        System.out.println(SecureUtil.md5("123" + "123"));
    }

    //16进制字节转字符串
    public static String convertToHexString(byte data[]) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            strBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        return strBuffer.toString();
    }
}
