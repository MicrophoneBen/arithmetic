package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 换零钱，加上剪枝法换零钱
 * @author: ghostben
 * @create: 2018-09-30 18:55
 **/
public class ChangeTips {
    public static void main(String[] args) {
        // 把8元钱换成5元，1元，5毛，2毛。
        int TOTAL = 8000;
        int TIPS01 = 50;
        int TIPS02 = 10;
        int TIPS03 = 5;
        int TIPS04 = 2;
        int changeTips = 0;

        changeTips(TOTAL, TIPS01, TIPS02, TIPS03, TIPS04, changeTips);

        changeTip(TOTAL, TIPS01, TIPS02, TIPS03, TIPS04, changeTips);

    }

    private static void changeTips(int TOTAL, int TIPS01, int TIPS02, int TIPS03, int TIPS04, int changeTips) {
        Long time = System.currentTimeMillis();
        for (int i = 0; i <= TOTAL / TIPS01; i++) {
            if (TOTAL - i * TIPS01 >= 0) {
                for (int j = 0; j <= TOTAL / TIPS02; j++) {
                    if (TOTAL - i * TIPS01 + j * TIPS02 >= 0) {
                        for (int k = 0; k <= TOTAL / TIPS03; k++) {
                            int g = (TOTAL - (i * TIPS01 + j * TIPS02 + k * TIPS03)) / 2;
                            if (g >= 0 && (i * TIPS01 + j * TIPS02 + k * TIPS03 + g * TIPS04) == TOTAL) {
                                // System.out.println("8 元 可以换成 ： " + i + "张5元" + j + "张1元" + k + "张5毛" + g + "张2毛");
                                changeTips++;
                            }
                        }
                    }
                }
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);

        System.out.println("共有" + changeTips + "种换法");
    }

    private static void changeTip(int TOTAL, int TIPS01, int TIPS02, int TIPS03, int TIPS04, int changeTips) {
        long time = System.currentTimeMillis();
        for (int i = 0; i <= TOTAL / TIPS01; i++) {
            for (int j = 0; j <= TOTAL / TIPS02; j++) {
                for (int k = 0; k <= TOTAL / TIPS03; k++) {
                    for (int g = 0; g <= TOTAL / TIPS04; g++) {
                        if ((i * TIPS01 + j * TIPS02 + k * TIPS03 + g * TIPS04) == TOTAL) {
                            //System.out.println("8 元 可以换成 ： " + i + "张5元" + j + "张1元" + k + "张5毛" + g + "张2毛");
                            changeTips++;
                        }
                    }
                }
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
        System.out.println("共有" + changeTips + "种换法");
    }
}