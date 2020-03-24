package com.itennishy.example.算法;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-23 14:11
 */
public class P10正则表达式匹配 {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "a.*"));
    }

    public static boolean isMatch(String pattern, String text) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }

    }
}
