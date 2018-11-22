package com.answer.mianshi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Base
{
    /*private String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }*/

    class Super{
        int flag=1;
        Super(){
            test();
        }
        void test(){
            System.out.println("Super.test() flag="+flag);
        }
    }
    class Suba extends Super{
        int flag=1;
        Suba(int i){
            flag=i;
            System.out.println("Sub.Sub()flag="+flag);
        }
        void test(){
            System.out.println("Sub.test()flag="+flag);
        }
}

    public static void main(String[] args) throws UnsupportedEncodingException {
//        Base b = new Suba();
//        new Base().new Suba(5);

        String a="%E9%87%91%E5%8D%8E%E5%B8%82";
        System.out.println(URLDecoder.decode(a,"UTF-8"));
    }
}