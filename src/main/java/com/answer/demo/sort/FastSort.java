package com.answer.demo.sort;


/**
 * created by liufeng
 * 2019/3/13
 * 快速排序
 */
public class FastSort {
    public static void main(String[] args) {
        int[] arr={3,5,2,7,4,9,10,1,6,100};
        fastSort(arr);
    }

    private static void fastSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int k=i+1;k<arr.length;k++){
                int temp=arr[i];
                if(arr[i]<arr[k]){
                    arr[i]=arr[k];
                    arr[k]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
