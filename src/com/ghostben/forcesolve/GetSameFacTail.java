package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 一个数字，他的平方后的尾数还是自己
 * @author: ghostben
 * @create: 2018-10-01 00:13
 **/
public class GetSameFacTail {
    public static void main(String[] args) {
        getOneNum();
        getDoubleNum();
        getthirdNum();
    }
    public static void getthirdNum() {
        for (int i = 100; i < 1000; i++) {
            if (i % 10 == 0 || i % 10 == 1 || i % 10 == 5 || i % 10 == 6 || i % 100 == 25 || i % 200 == 76) {
                long sum = i * i;
                if (sum % 1000 == i){
                    System.out.println("数字的本身是 ： " + i + " 平方后的数字是 ： " + sum);
                }
            }
        }
    }


    public static void getDoubleNum() {
        for (int i = 10; i < 100; i++) {
            if (i % 10 == 0 || i % 10 == 5 || i % 10 == 6 || i % 10 == 1) {

                int m = i * i;
                if (m % 100 == i) {
                    System.out.println("数字的本身： " + i + "平方的数字 ： " + m);
                }
            }
        }
    }


    public static void getOneNum() {

        for (int i = 0; i < 10; i++) {
            int sum = i * i;
            if (sum % 10 == i) {
                System.out.println("数字的本身是 ： " + i + " 平方后的数字是 ： " + sum);
            }
        }
    }
}