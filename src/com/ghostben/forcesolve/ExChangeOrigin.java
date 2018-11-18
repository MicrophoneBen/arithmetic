package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 常数变异法，把原来变动的数字用一个常数代替，然后后面使用变量去修改它
 * @author: ghostben
 * @create: 2018-10-01 18:18
 **/
public class ExChangeOrigin {
    public static void main(String[] args) {
        printStar(6);
        printChar(26);
    }


    /**
     * @author : Microphoneben
     * @date : 2018/10/1
     * @description : ExChangeOrigin
     * 打印一个星星的金字塔
     */

    public static void printStar(int line) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/10/2
    *@description : ExChangeOrigin
    *打印一坐金字塔，每一行使用字母的升序然后降序排列。
    */
    public static void printChar(int line){
        for(int i = 0; i < line; i++){
            for(int g= 0; g < line - i; g++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++) {
                System.out.print((char) ('A' + j));
            }
            for (int k = i - 1; k >= 0; k-- ){
                System.out.print((char)('A' + k));
            }
        System.out.println();
        }
    }
}