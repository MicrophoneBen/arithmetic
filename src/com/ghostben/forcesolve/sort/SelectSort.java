package com.ghostben.forcesolve.sort;

/**
 * @program: arithmetic
 * @description: 选择排序是基于冒泡排序的优化版本，在比较的次数上并没有优化，但是在交换位置上做了优化，只是需要交换比较少的次数
 * @author: ghostben
 * @create: 2018-11-18 21:06
 **/
public class SelectSort {
    public static void main(String[] args) {
        //使用选择排序
        int []array = {3,5,7,9,2,1,8,0};
        sort(array);
        for(int num : array){
            System.out.print(num + "   ");
        }
    }

    public static void sort(int [] arr){
        int outter; //指示在外面的指针，指示下一个需要填充的位置
        int min;  //指示当前查询数组中的最小数字
        int inner; //指示在内数组中，使用内指针表示。查找剩下的数字中最小的。
        for(int i = 0; i < arr.length; i++){
                min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //内层循环结束的时候，min指示的就是剩下的部分数组中的最小值，进行换位
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}