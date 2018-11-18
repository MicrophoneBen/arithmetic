package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 使用假设法来提高程序的逻辑性，假设之后修正。
 * 一个软件的优秀与否，除了正确性，效率性，稳定性，
 * 之外还有一个可读性，有时候为了可读性，我们可以牺牲效率性
 * @author: ghostben
 * @create: 2018-10-01 09:32
 **/
public class LogicGuessIf {
    public static void main(String[] args) {
        int[] arrays = new int[]{23, 56, 23, 67, 7, 8, 0, 34, 2, 22, 14};
        sortMaxNum(arrays);
        sort(34, 89, 0);
        getMax(9, 63, 2);
        doubleYear(1997);
    }

    public static void doubleYear(int year) {
        //因为大多数年份都不是闰年，所以这里先假设为false；
        boolean flag = false;

        //一般的嵌套表达
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            flag = true;
        }
        if (flag) {
            System.out.println("该年份是闰年");
        } else {
            System.out.println("不是闰年");
        }
    }

    //一个更加容易被理解的判断闰年的程序
    public static void getDoubleYear(int year){
        boolean flag = false;
        if(year % 4 == 0){
            flag = true;
        }
        if(year % 100 == 0){
            flag = false;
        }if(year % 400 == 0){
            flag = true;
        }
    }

    public static void sort(int a, int b, int c) {
        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("最大的数字是 ： " + max);

    }

    public static void getMax(int a, int b, int c) {
        int max = a;
        if (a < b) {
            max = b;
        }
        if (a < c) {
            max = c;
        }
        System.out.println("最大的数字是 ： " + max);
    }


    /**
     * @author : Microphoneben
     * @date : 2018/10/1
     * @description : LogicGuessIf
     * 寻找一个数组中的最大值，使用假设修正法，先假设一个最大的值，然后后面再进行比较，找到比他大的值之后进行修正
     */
    public static void sortMaxNum(int... arr) {
        int max = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大的数字是： " + max);
    }

}