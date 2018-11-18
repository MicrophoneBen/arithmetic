package com.ghostben.forcesolve;

/**
 * @program: arithmetic
 * @description: 暴力破解法，三个例子，一个是计算鸡兔同笼问题，一个是韩信点兵问题，一个换钱问题
 * @author: ghostben
 * @create: 2018-09-27 23:49
 **/
public class ForceCalculator {

    public static void main(String[] args) {
        getAnimalNum(50, 120);


        int[] soldiers =  new int[1000];
        for(int j = 0, i = 1000; j < 100; j++ ){
            soldiers[j] = i;
            i ++ ;
        }
        getSoldiers(soldiers);

        getTicketMoney(10);

    }

    public static void getTicketMoney(int total){
        int solution = 0;
        //换一元
        for(int i = 0; i < total / 1; i++){
            //换5毛
            for(int j = 0; j < total / 0.5; j++){
                //换2毛
                for(int k = 0; k < total / 0.2; k++){
                    if((i + j * 0.5 + k *0.2) == total){
                        solution ++;
                        System.out.println("可以换1元 ： " + i +" , 可以换5毛 ： " + j + " ,可以换2毛 ： " +  k);
                    }
                }
            }
        }
        System.out.println("一共有 " + solution + " 种方案");
    }

    public static void getSoldiers(int...soldiers) {
        int numOfSoldier = 0;
        for (int soldier : soldiers) {
            if (soldier % 5 == 0) {
                if (soldier % 7 == 4) {
                    if (soldier % 3 ==0) {
                        numOfSoldier = soldier;
                        //这里要加break来跳出循环，不加的时候，总是会让numOfSoldier = 0;
                        break;
                    }
                }
            } else {
                numOfSoldier = 0;
            }
        }
        if (numOfSoldier == 0) {
            System.out.println("查无数据");
        } else {
            System.out.println("军队中士兵的数目是 ：" + numOfSoldier);
        }
    }

    public static void getAnimalNum(int head, int foot){
        int numOfHen = 0;
        int numOfRabbit = 0;

        for (int i = 0; i <= head; i++){
            numOfHen = i;
            numOfRabbit = head - i;

            if((numOfHen * 2 + numOfRabbit * 4) == foot){
                System.out.println("鸡的数目是 ：" + numOfHen + " , 兔子的数目是 ： " + numOfRabbit);
            }
        }
    }
}