package com.answer.mianshi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by liufeng
 * 2018/9/18
 */
public class Mianshi4 {
    /*一闪一闪亮晶晶，满天都是小星星，牛牛晚上闲来无聊，便躺在床上数星星。
    牛牛把星星图看成一个平面，左上角为原点(坐标为(1, 1))。现在有n颗星星，他给每颗星星都标上坐标(xi，yi)，表示这颗星星在第x行，第y列。
    现在，牛牛想问你m个问题，给你两个点的坐标(a1, b1)(a2，b2)，表示一个矩形的左上角的点坐标和右下角的点坐标，请问在这个矩形内有多少颗星星（边界上的点也算是矩形内）。
    输入描述:
    第一行输入一个数字n(1≤n≤100000)，表示星星的颗数。
    接下来的n行，每行输入两个数xi和yi(1≤xi，yi≤1000），表示星星的位置。
            然后输入一个数字m(1≤m≤100000), 表示牛牛询问问题的个数。
    接下来m行，每行输入四个数字a1，b1，a2，b2(1≤a1＜a2≤1000), (1≤b1＜b2≤1000）
    题目保证两颗星星不会存在于同一个位置。


    输出描述:
    输出一共包含m行，每行表示与之对应的每个问题的答案。

    输入例子1:
        4
        1 1
        2 2
        3 3
        1 3
        4
        1 1 2 2
        1 1 3 3
        2 2 3 3
        1 2 2 3

     输出例子1:
        2
        4
        2
        2

*/

    public static void main(String[] args) {
        //提示输入星星个数
        System.out.println("输入星星的个数：");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n>0){
            System.out.println("输入星星的位置例如1 2：");
            List<int[]> list=new ArrayList<>();
            for(int i=1;i<=n;i++){
                Scanner sc=new Scanner(System.in);
                String num=sc.nextLine();
                num=num.replace(" ","");
                if(num.length()==2){
                    int num1=Integer.parseInt(num.substring(0,1));
                    int num2=Integer.parseInt(num.substring(1,num.length()));
                    int[] array={num1,num2};
                    list.add(array);
                }else {
                    System.out.println("星星位置输入不合法");
                }

            }

            //输入矩形范围
            System.out.println("询问问题的个数");
            Scanner scan=new Scanner(System.in);
            int problemNum=scan.nextInt();
            if(problemNum>0){
                for(int i=1;i<=problemNum;i++){
                    System.out.println("输入矩形范围");
                    Scanner sc=new Scanner(System.in);
                    String num=sc.nextLine();
                    num=num.replace(" ","");
                    char[] arr=num.toCharArray();
                    int count=0;
                    for(int[] nums:list){
                        int x=nums[0];
                        int y=nums[1];
                        int minX=Integer.parseInt(String.valueOf(arr[0]));
                        int maxX=Integer.parseInt(String.valueOf(arr[2]));
                        int minY=Integer.parseInt(String.valueOf(arr[1]));
                        int maxY=Integer.parseInt(String.valueOf(arr[3]));
                        if(x>=minX && x<=maxX && y>=minY && y<=maxY){
                            count++;
                        }
                    }
                    System.out.println("矩阵"+num+"中星星的数量："+count);
                }
            }

        }
    }
}
