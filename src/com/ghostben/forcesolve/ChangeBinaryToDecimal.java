package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 进制之间的相互转化，包括从其他进制到十进制。从十进制取真值到其他进制
 * @author: ghostben
 * @create: 2018-10-10 23:45
 **/
public class ChangeBinaryToDecimal {
    public static void main(String[] args) {
        changeToDecimal(2001201102,3);

        changeToOther(changeToDecimal(2001201102,3),5);
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/10/10
    *@Parameter :  [number, n]  number 是我们传入的进制数， n 是几进制的数字
    *@return    : void
    *@description : ChangeBinaryToDecimal
    *
    */
    public static int changeToDecimal(int number, int n){
        String string = "" + number;
        char [] chars = string.trim().toCharArray();

        int decimalResult = 0;
        for(int i = 0; i < chars .length; i++){
            decimalResult = decimalResult * n +(chars[i] - '0');
        }
        System.out.println(n + " 进制转为十进制，结果： " + decimalResult);

        return decimalResult;
    }
    
    /**
    *@author    : Microphoneben
    *@date      : 2018/10/10
    *@Parameter :  [number, n] number是我们传入的等待转化的数字，n是要转化的多少进制
    *@return    : void
    *@description : ChangeBinaryToDecimal
    *
    */
    public static void changeToOther(int number, int n){
        System.out.print(number);
            String string = "";
        while (true) {
            if(number == 0){break;}
            int num1 = number % n;
            number = number / n;
            string = num1 + string;
        }
        System.out.println("转换为 "+ n +"进制是： " +string);
    }
}