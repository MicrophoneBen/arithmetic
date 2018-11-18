package com.ghostben.forcesolve.search;

/**
 * @program: arithmetic
 * @description: 二分查找，查找的数组必须先是有序的，有序数组才可以进行二分查找，否则查找是不准确的。
 * @author: ghostben
 * @create: 2018-11-18 17:43
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 3, 2, 0, 4, 8};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + "   ");
        }
        System.out.println();

        System.out.println(binarySearch(arr, 9));

    }

    public static void sort(int[] arr) {
        //冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    //二分查找
    public static String binarySearch(int[] arr, int key) {
        int begin = 0;
        int end = arr.length - 1;
        //二分查找中间位
        int mid = 0;
        while (true) {
            if (arr[mid] == key) {
                return arr[mid] + "  " + mid;
            }else if(begin > end){
                return "没有找到";
            }else {
                if (arr[mid] > key) {
                    end = mid - 1;
                    mid = (begin + end) / 2;
                } else if (arr[mid] < key) {
                    begin = mid + 1;
                    mid = (begin + end) / 2;
                }
            }
        }
    }
}