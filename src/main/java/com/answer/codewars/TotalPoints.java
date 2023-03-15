package com.answer.codewars;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/2/28
 */
public class TotalPoints {
    public static void main(String[] args) {
        assertEquals(30, TotalPoints.points(new String[]
                {"1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"}));

        assertEquals(10, TotalPoints.points(new String[]
                {"1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"}));

        assertEquals(0, TotalPoints.points(new String[]
                {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(15, TotalPoints.points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(12, TotalPoints.points(new String[]
                {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));

    }

    private static int points(String[] games) {
        int count=0;
        for(String str:games){
            String[] xy=str.split(":");
            int x=Integer.parseInt(xy[0]);
            int y=Integer.parseInt(xy[1]);
            if(x>y){
                count=count+3;
            }
            if(x==y){
                count=count+1;
            }
        }
        return count;
    }
}
