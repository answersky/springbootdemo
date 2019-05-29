package com.answer.demo.random;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * created by liufeng
 * 2019/5/8
 * 抽奖概率
 */
public class Cj {

    /*
     * 概率分布 1,2，3.......100
     * 用随机数函数随机生成1~100的数，
     * 然后看生成的数在哪个区间对应：
     * 1~30鞋子
     * 31~45袜子
     * 46~146裤子
     * ........
     * 以此类推
     */

    public static void main(String[] args) {
        Map<String,Integer> param=new LinkedHashMap<>();
        param.put("x",1);
        param.put("w",50);
        param.put("k",15);
        param.put("n",34);
//        Map<String,String> map=createSection(param);
//        System.out.println(map);

        createRandomNum();
    }

    /**
     * param={鞋子：1%,袜子：50%,裤子：15%}
     * @param param
     * @return
     */
    private static Map<String,String> createSection(Map<String,Integer> param){
        Map<String,String> map=new LinkedHashMap<>();
        int first=1;
        for(Map.Entry<String,Integer> entry:param.entrySet()){
            String key=entry.getKey();
            Integer value=entry.getValue();
            int last=first+value-1;
            String section=first+"~"+last;
            map.put(key,section);
            first=last+1;
        }
        return map;
    }

    /**
     * 生成随机数
     * @return
     */
    private static int createRandomNum(){
        ThreadLocalRandom random =  ThreadLocalRandom.current();
        int num=random.nextInt(1,101);
        System.out.println("random number:"+num);
        return num;
    }
}
