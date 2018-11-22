package com.answer.mianshi;

/**
 * created by liufeng
 * 2018/9/17
 */
public class Mianshi1 {
    private static int x=100;
    //1分，2分，5分硬币共100个，总计2.64元，硬币各有多少？

    public static void main(String[] args) {
        Mianshi1 ma=new Mianshi1();
        ma.x++;
        System.out.println(ma.x);


        Integer i01 = 59;
        int i02 = 59;
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01==i02);
        System.out.println(i03.equals(i04));


        for(int x=1;x<=100;x++){
            for(int y=1;y<=100;y++){
                int z=100-x-y;
                if(x+2*y+5*z==264){
                    System.out.println("x="+x+" y="+y+" z="+z);
                }
            }
        }
    }
}
