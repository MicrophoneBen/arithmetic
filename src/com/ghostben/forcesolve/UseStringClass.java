package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 使用String的API进行各种实验，同时熟悉掌握使用的方法
 * @author: ghostben
 * @create: 2018-10-10 21:02
 **/
public class UseStringClass {
    public static void main(String[] args) {
        getSameChar("abcdfsgage");

        //进行ASCII转换
        toSecretString("abcd");

        //进行Unicode转换
        toSecretString("我爱中国");
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/10/10
    *@description : UseStringClass
    **
    * 寻找一个字符串中的重复的字符。 通常我们的想法是使用两个循环进行，第一个循环获得要查找的字符，第二个是在剩下的字符串中找重复的字符
    */
    public static void getSameChar(String string){
        //方法一
        for(int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            for(int j = i + 1; j < string.length(); j++){
                if(ch == string.charAt(j)){
                    System.out.println("存在重复字符 " + ch +" "+  i +" "+ j);
                }
            }
        }

        //方法二
        boolean flage = false;
        for(int i = 0; i< string.length(); i++){
            char ch = string.charAt(i);
            if(i != string.lastIndexOf(ch)){
                System.out.println("存在重复元素" + ch +" " + i + " " + string.lastIndexOf(ch));
            }
        }
    }


    /**
    *@author    : Microphoneben
    *@date      : 2018/10/10
    *@description : UseStringClass
    **
    * 串一旦被定义是确定的，重新的串总new出来的，这个时候会使用StringBuilder 或者StringBuffer
     * 通常我们会使用ToCharArray 转为字符数组
    */

    public static void toSecretString(String string){
        //获得字符数组
        char [] chars = string.toCharArray();
        // 对字符加密
        for(int i = 0; i < chars.length; i++){
            //这样会默认进行类型转换，或者chars[i] ++;
            chars[i] += 2;

        }

        // 转为串
        String str = new String(chars);
        System.out.println(str);
    }

}