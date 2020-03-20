package com.itennishy.example.排序算法.快速排序;

import java.util.Arrays;

/**
 * @author xiehuishegn@hotmail.com
 * @version 1.0
 * @date 2020-03-20 16:49
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSortImpl(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序算法
     * 一种分而治之的排序算法
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static void quickSortImpl(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        //指定分界基数
        if (start > end) {
            return;
        }
        int base = arr[low];
        int tmp;
        while (start < end) {
            while (base <= arr[end] && start < end) {
                end--;
            }
            while (base >= arr[start] && start < end) {
                start++;
            }
            if (start < end) {
                tmp = arr[end];
                arr[end] = arr[start];
                arr[start] = tmp;
            }
        }
        arr[low] = arr[start];
        arr[start] = base;
        quickSortImpl(arr, low, end - 1);
        quickSortImpl(arr, end + 1, high);
    }
}
