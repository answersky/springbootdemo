package com.answer.codewars;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/2/28
 */
public class Line {
    public static void main(String[] args) {
        assertEquals("YES", Line.Tickets(new int[] {25, 25, 50}));
        assertEquals("NO", Line.Tickets(new int[] {25, 100}));
        assertEquals("NO", Line.Tickets(new int[] {25, 25, 50, 50, 100}));
    }

    private static String Tickets(int[] peopleInLine) {
        //售票员手里的钱
        List<Integer> sales=new ArrayList<>();
        int give_change=0;
        for(int i=0;i<peopleInLine.length;i++){
            //第一个人不是25买票，那么售票员没钱找，那么返回no
            if(i==0){
                int first=peopleInLine[i];
                if(first!=25){
                    return "NO";
                }
                sales.add(peopleInLine[i]);
                continue;
            }
            //25的倍数关系 25,50,100
            if(peopleInLine[i]>=25){
                //判断售票员手里是否有钱够找零(要么25，要么75=25+50)
                Integer need=peopleInLine[i]-25;
                boolean flag=false;
                if(need==0){
                    //刚好不需要找零
                    flag=true;
                }
                if(need==25){
                    if(sales.indexOf(25)!=-1){
                        //执行找零动作
                        sales.remove(need);
                        flag=true;
                    }
                }
                if(need==75){
                    if(sales.indexOf(25)!=-1 && sales.indexOf(50)!=-1){
                        sales.remove(new Integer(25));
                        sales.remove(new Integer(50));
                        flag=true;
                    }
                }
                if(flag){
                    sales.add(peopleInLine[i]);
                }else {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
