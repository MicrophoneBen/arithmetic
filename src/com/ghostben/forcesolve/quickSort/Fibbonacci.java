package com.ghostben.forcesolve.quickSort;

/**
 * @program: arithmetic
 * @description: 斐波那契数列，使用循环实现，使用递归实现
 * @author: ghostben
 * @create: 2018-11-18 00:07
 **/
public class Fibbonacci {
    public static void main(String[] args) {
       int result = loop(4); //函数默认有了两个初始的数字，所以这里其实是对应第6个数字
        System.out.println(result);


        int runresult = runPrivate(6);  //递归实现，这里的6就是计算第六个数
        System.out.println(runresult);

    }

    public static int loop(int n){
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        for(int i = 0; i<n; i++){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }

    public static int runPrivate(int n){
        if(n ==1 || n == 2){
            return 1;
        }else{
            return runPrivate(n-1) + runPrivate(n-2);
        }
    }
}