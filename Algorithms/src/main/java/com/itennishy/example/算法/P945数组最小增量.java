package com.itennishy.example.算法;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-22 11:53
 */
public class P945数组最小增量 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(arr));
    }

    public static int minIncrementForUnique(int[] nums) {
//        第一种方法
//        Arrays.sort(A);
//        int count = 0;
//        int pre = -1;
//        for (int i = 0; i < A.length; i++) {
//            if (pre == -1) {
//                pre = A[i];
//                continue;
//            }
//            while (A[i] - pre <= 0) {
//                A[i] = A[i] + 1;
//                count++;
//            }
//            pre = A[i];
//        }
//        return count;

//        第二种方法
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] status = new int[50000];
        int counts = 0;

        for (int num : nums) {
            status[num]++;
        }

        for (int i = 0; i < 50000; i++) {
            if (status[i] > 1) {
                int expect = status[i] - 1;
                counts += expect;
                status[i + 1] += expect;
                status[i] = 1;
            }
        }

        return counts;
    }
}
