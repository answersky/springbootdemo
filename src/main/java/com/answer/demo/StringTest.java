package com.answer.demo;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/7/4 10:39
 * @className: StringTest
 * @packageName: com.answer.demo
 * @description:
 */
public class StringTest {
    public static void main(String[] args) {
//        String text="我的图片[R-C.jpg](http://124.70.157.173:9001/base/file/image/preview?imgPath=obs:MD20210918064853y3/test-lims/95213581820062022_R-C.jpg) 文本";
        String text = "[R-C.jpg](http://124.70.157.173:9001/base/file/image/preview?imgPath=obs:MD20210918064853y3/test-lims/95213581820062022_R-C.jpg)";
        String imgText = text.substring(text.indexOf("["), text.indexOf(")") + 1);
        System.out.println(imgText);
        String newText = text.replace(imgText, "$img");
        System.out.println(newText);
        String[] texts = newText.split("\\$img");
        System.out.println("文本数组大小：" + texts.length);
        if (texts.length > 0) {
            String leftText = texts[0];
            System.out.println("图片左边的文本：" + leftText);
            String rightText = texts[1];
            System.out.println("图片右边的文本：" + rightText);
        }

        String s = "222${pro}${xxx}555${eeee}5555";
        String[] sarr = s.split("\\$");
        for (int i = 0; i < sarr.length; i++) {
            if (ObjectUtil.isNotEmpty(sarr[i]) && sarr[i].contains("{")) {
                System.out.println("$" + sarr[i]);
            } else {
                System.out.println(sarr[i]);
            }
        }

    }
}
