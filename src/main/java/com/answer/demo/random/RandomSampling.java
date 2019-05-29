package com.answer.demo.random;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import org.assertj.core.util.Lists;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机取样，抽奖方法，采用别名
 * @author 胡祥
 * @date 2019/1/10 17:06
 */
public class RandomSampling {
    /**
     * 奖品概率数组
     */
    private double[] probability;
    /**
     * 别名数组
     */
    private int[] alias;

    public RandomSampling(List<Double> probabilities){
        probability = new double[probabilities.size()];
        alias = new int[probabilities.size()];

        double avg = 1.0/probabilities.size();

        Deque<Integer> smallList = new ArrayDeque<>();
        Deque<Integer> bigList = new ArrayDeque<>();

        for (int i = 0; i < probabilities.size(); i++) {
            if (probabilities.get(i) >= avg) {
                bigList.add(i);
            }else{
                smallList.add(i);
            }
        }
        System.out.println("bigList:"+JSONUtils.toJSONString(bigList));
        System.out.println("smallList:"+JSONUtils.toJSONString(smallList));

        while (!smallList.isEmpty() && !bigList.isEmpty()) {
            int small = smallList.pop();
            int big = bigList.pop();

            probability[small] = probabilities.get(small) * probabilities.size();
            alias[small] = big;

            probabilities.set(big, probabilities.get(small) + probabilities.get(big) - avg);

            if (probabilities.get(big) >= avg) {
                bigList.add(big);
            }else{
                smallList.add(big);
            }
        }

        while (!smallList.isEmpty()) {
            probability[smallList.pop()] = 1.0;
        }
        while (!bigList.isEmpty()) {
            probability[bigList.pop()] = 1.0;
        }
    }

    public int sampling() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int column = random.nextInt(probability.length);
        double sample = random.nextDouble();
        return probability[column] > sample ? column : alias[column];
    }

    public static void main(String[] args) {
        Gson gson=new Gson();
        //probabilities 合要达到100%
        List<Double> probabilities= Lists.newArrayList(0.5,0.4,0.1);
        RandomSampling randomSampling=new RandomSampling(probabilities);
        System.out.println("probability:"+gson.toJson(randomSampling.probability));
        System.out.println("alias:"+gson.toJson(randomSampling.alias));
        int index=randomSampling.sampling();
        System.out.println(index);
    }

}
