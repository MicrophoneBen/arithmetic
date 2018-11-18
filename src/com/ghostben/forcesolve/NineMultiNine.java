package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 9*9的乘法口诀表
 * @author: ghostben
 * @create: 2018-09-30 18:03
 **/
public class NineMultiNine {

    public static void main(String[] args) {

        int HOR = 9;

        for (int i = 1; i <= HOR; i++) {
                for (int j = 1; j <= i; j++){
                    System.out.print("   " +  j + "X" + i + "=" + i*j);
                }
            System.out.println();
        }
    }
}