package com.itennishy.example.二分查找;

import java.util.Arrays;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-20 18:06
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {30, 2, 3, 2, 1, 20, 19};
        Arrays.sort(a);
        int index = myBinarySearch(a, 21);

        System.out.println(index);
    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;

    }
}
