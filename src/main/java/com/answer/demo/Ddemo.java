package com.answer.demo;

import java.util.ArrayList;
import java.util.List;
/*
人人网面试题
 */

public class Ddemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 4, 69, 10, 90, 80, 56};
        Integer min = arr[0];
        Integer max = arr[0];
        //找出最小值,最大值
        for (int i = 1; i < arr.length; i++) {
            Integer num = arr[i];
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        Integer[] newArr = new Integer[arr.length];

        newArr[0] = max;
        newArr[newArr.length - 1] = min;

        List<Integer> arrList = new ArrayList<>();
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != min && arr[k] != max) {
                arrList.add(arr[k]);
            }
        }

        for (int k = 1; k < arr.length - 1; k++) {
            newArr[k] = arrList.get(k - 1);
        }


        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }

        //中间的顺序不能保证是原来的顺序
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[0])
                swap(arr, i, 0);
            if (arr[i] < arr[n - 1])
                swap(arr, i, n - 1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void swap(Integer[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
