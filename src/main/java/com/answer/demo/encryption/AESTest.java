package com.answer.demo.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * created by liufeng
 * 2018/11/29
 */
public class AESTest {
    public static void main(String[] args) {
        //aes加密是对des的升级版
        String mingwen="answer&中文";
        String password="1234567";
        String miwen=encrypt(mingwen,password);
        //wx5wmY2pjSiotpzoj5PE6Q==
        System.out.println("加密："+miwen);

        String jiemi=dencrypt(miwen,password);
        System.out.println("解密："+jiemi);
    }

    /**
     * 加密
     * @param string 明文
     * @param password 密钥
     * @return
     */
    public static String encrypt(String string,String password){
        try {
            // 创建AES的Key生产者
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            // 根据用户密码，生成一个密钥
            SecretKey secretKey = kgen.generateKey();
            // 返回基本编码格式的密钥
            byte[] enCodeFormat = secretKey.getEncoded();
            // 转换为AES专用密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //加密
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] data=cipher.doFinal(string.getBytes("utf-8"));
//            return Base64Util.encode(data);
            return ParseSystemUtil.parseByte2HexStr(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解密
    public static String dencrypt(String string,String password){
        try {
            // 创建AES的Key生产者
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            // 根据用户密码，生成一个密钥
            SecretKey secretKey = kgen.generateKey();
            // 返回基本编码格式的密钥
            byte[] enCodeFormat = secretKey.getEncoded();
            // 转换为AES专用密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //解密
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,key);
//            byte[] data=cipher.doFinal(Base64Util.decode(string.toCharArray()));
            byte[] data=cipher.doFinal(ParseSystemUtil.parseHexStr2Byte(string));
            return new String(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
