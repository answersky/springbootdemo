package com.answer.mianshi;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * created by liufeng
 * 2019/4/26
 * 笛卡尔积
 */
public class Decar {
    public static void main(String[] args) {
        List<List<String>> lists=new ArrayList<>();
        List<String> objects1= Lists.newArrayList("1","2");
        List<String> objects2= Lists.newArrayList("a","b","c");
        List<String> objects3= Lists.newArrayList("d","e");
        List<String> objects4= Lists.newArrayList("4");
        lists.add(objects1);
        lists.add(objects2);
        lists.add(objects3);
        lists.add(objects4);
//        decar(objects1,objects2);
        decarOpt(null,lists);
    }

    /**
     * {1,a},{1,b},{2,a},{2,b}
     * @param objects1
     * @param objects2
     */
    private static void decar(List<String> objects1, List<String> objects2) {
        List<List<String>> result=new ArrayList<>();
        for(String a:objects1){
            for(String b:objects2){
                List<String> decars=new ArrayList<>();
                System.out.println("{"+a+","+b+"}");
                decars.add(a);
                decars.add(b);
                result.add(decars);
            }
        }
        System.out.println(result);
    }

    private static void decarOpt(List<List<String>> result,List<List<String>> datas){
        int size=datas.size();//循环的层数
        int i=1;//下一个循环的list
        for(String a:datas.get(0)){//第一层循环
            List<String> b=new ArrayList<>();
            b.add(a);
            calculate(datas,i,b,size-1);
        }
    }

    private static void calculate(List<List<String>> datas,int i,List<String> b,int size){
        size=size-1;
        for(String a:datas.get(i)){
            if(size==0){
                List<String> decars=new ArrayList<>();
                decars.addAll(b);
                decars.add(a);
                initBList(datas,decars);
            }else {
                b.add(a);
                calculate(datas,i+1,b,size);
            }

        }
    }

    private static void initBList(List<List<String>> datas,List<String> decars){
        System.out.println("初始化前的："+decars);
        int size=datas.size();
        List<String> result=new ArrayList<>();
        if(decars.size()>size){
            result.add(decars.get(0));
            int start=decars.size()-size;
            for(int i=start;i<decars.size();i++){
                result.add(decars.get(i));
            }
        }else {
            result.addAll(decars);
        }

        System.out.println("初始化后的："+result);
    }

}
