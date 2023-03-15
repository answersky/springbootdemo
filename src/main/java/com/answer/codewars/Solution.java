package com.answer.codewars;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by liufeng
 * 2019/7/22
 */
public class Solution {
    public static void main(String[] args) {
        doTest(new int[]{1,2,3},          new int[]{0,2});
        doTest(new int[]{1234,5678,9012}, new int[]{1,2});
        doTest(new int[]{2,2,3},          new int[]{0,1});
    }

    private static void doTest(int[] numbers, int[] expected) {
        int target = numbers[expected[0]] + numbers[expected[1]];
        int[] actual = Solution.twoSum(numbers, target);
        if ( null == actual )
        {
            System.out.format("Received a null\n");
            assertNotNull(actual);
        }
        if ( actual.length != 2 )
        {
            System.out.format("Received an array that's not of length 2\n");
            assertTrue(false);
        }
        int received = numbers[actual[0]] + numbers[actual[1]];
        assertEquals(target, received);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] arr=new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int sum=numbers[i]+numbers[j];
                if(target==sum){
                    arr[0]=i;
                    arr[1]=j;
                    System.out.println("i="+i+"  j="+j);
                    return arr;
                }
            }
        }
        return null;
    }
}
