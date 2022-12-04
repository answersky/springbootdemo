package com.answer.mianshi;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by liufeng
 * 2020/11/26
 */
public class Test1 {
    public static void main(String[] args) {
        //false
        System.out.println(Integer.valueOf(1024) == Integer.valueOf(1024));
        //true
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
        function(5);


        Matcher m = Pattern.compile("(\\D*)(\\d+)(.*)").matcher("This order was placed for QT3000!OK?");
        if (m.find()) {
            System.out.print(m.group(1));
            System.out.print(":" + m.group(2));
            System.out.println(":" + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }

        System.out.println(func(9, 9));


        Integer a = 987564321;
        char[] chars = a.toString().toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int k = length - 1 - i;
            if (k > i) {
                char temp = chars[i];
                chars[i] = chars[k];
                chars[k] = temp;
            }


        }
        System.out.println(new String(chars));
    }

    private static int func(int x, int y) {
        if (x + y <= 5)
            return 2 * y;
        if (y <= 3)
            return x + y;
        return func(x - 2, y - 2);
    }

    private static void function(int k) {
        if (k > 0) {
            function(k - 1);
        }
        System.out.println(k);
    }
}
