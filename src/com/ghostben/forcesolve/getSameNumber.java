package com.ghostben.forcesolve;

import java.util.Arrays;

/**
 * 2z@program: arithmetic
 * @description: 一个四位数字的循环最大减最小，最后得到一个固定数字
 * @author: ghostben
 * @create: 2018-10-10 22:27
 **/
public class getSameNumber {
    public static void main(String[] args) {
        findSameResult(5770);
    }

    public static void findSameResult(int number){

        while (true) {
            System.out.println("计算转换结果 ： " + number);
            // 把数字换为字符串
            String string = "" + number;

            // 把字符串转为字符数组，就可以取出每一个数字
            char [] chars = string.trim().toCharArray();

            //从小到大排列这个字符数组
            Arrays.sort(chars);

            int number1 = 0;
            int number2 = 0;

            int result = 0;
            //重排后取得最小数字
            for(int i = 0; i < chars.length; i++){
                number1 = number1 * 10 + (chars[i] - '0');
            }
            //重排后取得最大数字
            for(int j = chars.length -1; j >= 0; j--){
                number2 = number2 * 10 + (chars[j] - '0');
            }

            result = number2 - number1;

            if(number == result){
                break;
            }

            number = result;
        }
    }

}