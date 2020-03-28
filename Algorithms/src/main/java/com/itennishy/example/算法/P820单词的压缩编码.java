package com.itennishy.example.算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-28 17:09
 */
public class P820单词的压缩编码 {
    public static void main(String[] args) {
        String[] arr = new String[]{"timme", "me", "bell"};
        System.out.println(minimumLengthEncoding(arr));
    }

    public static int minimumLengthEncoding(String[] words) {

        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k) {
                System.out.println(word.substring(k));
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word : good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
