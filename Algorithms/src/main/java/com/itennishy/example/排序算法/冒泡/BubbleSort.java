package com.itennishy.example.排序算法.冒泡;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{5, 3, 6, 2, 7, 9, 1};
        int temp;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(numbers));
    }


}
