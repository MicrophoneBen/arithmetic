package com.ghostben.forcesolve.quickSort;

/**
 * @program: arithmetic
 * @description: 快速排序，快速排序算法实现
 * @author: ghostben
 * @create: 2018-11-17 23:58
 **/
public class SortQuick {
    public static void main(String[] args) {

        int[] array = {5, 3, 7, 8, 2, 9, 4, 6};
        quickSort(array);
        for (int num : array) {
            System.out.print(num + "  ");
        }
    }

    //循环调用排序单元快排
    public static void quickSort(int [] arr){
        int mid;
        mid = sortUnit(arr,0,arr.length-1);
        sortUnit(arr,0,mid-1);
        sortUnit(arr,mid+1, arr.length-1);
    }

    //进行一次快速排序的结果
    public static int sortUnit(int[] arr, int begin, int end) {
        int num = arr[begin];
        int i = begin;  //开始指针往后找
        int j = end;    //开始指针往前找
        while (i < j) {
            while (i < j) {
                if (arr[j] < num) {
                    arr[i] = arr[j];
                    break; //找到了交换位置后跳出循环
                }
                j--;
            }
            while (i < j) {
                if (arr[i] >= num) {
                    arr[j] = arr[i];
                    break; //找到交换的位置后跳出循环
                }
                i++;
            }
        }
        //循环结束，这个时候i==j
        arr[i] = num;
        return i; //返回排序好后的中间的标杆位置
    }
}