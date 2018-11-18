package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 串与其他类型的相互转化，逻辑锻炼
 * @author: ghostben
 * @create: 2018-10-10 21:33
 **/
public class StringExchange {
    public static void main(String[] args) {
        toInteger("1234");

        toInteger("sadf2445");
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/10/10
    *@Parameter :  [string]
    *@return    : void
    *@description : StringExchange
    *  转字符串为数字
    */
    public static void toInteger(String string){
        //方法一
        Integer number = null;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(number);

        //方法二
        String str = " " + string;
        char [] chars = str.trim().toCharArray();
        for(char ch : chars){
            System.out.print(ch + "  ");
        }
        System.out.println();

        //转Integer
        int trueNumber = 0;
        for (char integer : chars){
            //取得字符真值,这里还应该加一个判断，取出来的字符是数字
            if (integer >= '0' && integer <= '9') {
                trueNumber = trueNumber * 10 + (integer - '0');
            } else {
                System.out.println("字符串不是数字，无法转换");
                break;
            }
        }
        if (trueNumber != 0) {
            System.out.println(trueNumber);
        }
    }


}