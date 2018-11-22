package com.answer.mianshi;

import org.assertj.core.util.Lists;

import java.util.*;

public class Main{

    /*
        输入描述:
            输入第一行为数字个数n (n ≤ 20)
            第二行为n个数xi (1 ≤ xi ≤ 100000)
        输出描述:
            输出最小不能由n个数选取求和组成的数
     */

    public static void main(String[] args){
        Scanner arrStr=new Scanner(System.in);
        String str=arrStr.nextLine();
        String[] num=str.split(" ");
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            result.add(Integer.parseInt(num[i]));
        }
        System.out.println(result);
        List<String> arrs=new ArrayList<>();
        List<Integer> results=new ArrayList<>();
        calu(result,arrs,results);
        System.out.println("组合："+arrs);
        System.out.println("求和"+results);
        int maxNUm=Collections.max(results);

        List<Integer> cals=new ArrayList<Integer>();
        for(int k=1;k<=maxNUm+1;k++){
            if(!results.contains(k)){
                cals.add(k);
            }
        }
        int minNum=Collections.min(cals);
        System.out.println("结果"+minNum);
    }

    private static void calu(List<Integer> list,List<String> result,List<Integer> results){
        //1 2 3 4 5
        for(int i=0;i<list.size();i++){
            String first=String.valueOf(list.get(i));
            result.add(first);
            results.add(list.get(i));
            System.out.println(first);
            format(i,list,first,result,results);
        }
    }

    private static void format(int k,List<Integer> list,String result,List<String> res,List<Integer> results){
        for(int m=k+1;m<list.size();m++){
            String third=result+""+list.get(m);
            res.add(third);
            results.add(reuslt(third));
            System.out.println(third);
            format(m,list,third,res,results);
        }
    }

    private static int reuslt(String numStr){
        char[] chars=numStr.toCharArray();
        int result=0;
        for(char ch:chars){
            result=result+Integer.parseInt(String.valueOf(ch));
        }
        return result;
    }
}