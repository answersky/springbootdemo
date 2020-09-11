package com.answer.java8.day3;


import java.util.concurrent.RecursiveTask;

/**
 * created by liufeng
 * 2020/9/2
 * 拆分，合并框架
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private  long[] numbers;
    private  int start;
    private  int end;

    public ForkJoinSumCalculator(long[] numbers,int start,int end){
        this.numbers=numbers;
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        int length=end-start;
        //当拆分到100的时候，就不再拆分，直接求和
        if(length<=100){
            long sum=0;
            for(int i=start;i<end;i++){
                sum=sum+numbers[i];
            }
            return sum;
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        //拆分 利用另一个 ForkJoinPool 线程异步执行新创建的子任务
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
        long rightResult=rightTask.compute();
        //join的位置跟花费时长也有关系，join会阻塞其他线程执行
        long leftResult=leftTask.join();

        return leftResult+rightResult;
    }
}
