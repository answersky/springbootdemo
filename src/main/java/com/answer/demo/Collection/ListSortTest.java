package com.answer.demo.Collection;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * created by liufeng
 * 2020/11/5
 */
public class ListSortTest {
    public static void main(String[] args) {
        List<Integer> nums= Lists.newArrayList(1,8,3,6,9,2);
        int[] arr=new int[10];
        for(Integer num:nums){
            arr[num]++;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                System.out.println(i);
            }
        }
    }
}
