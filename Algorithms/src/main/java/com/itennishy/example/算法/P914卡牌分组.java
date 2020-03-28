package com.itennishy.example.算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-27 16:50
 */
public class P914卡牌分组 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,3,2,1};
        System.out.println(hasGroupsSizeX(arr));
     }

    public static boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        int count = 0;
        int t = -1;
        List<Integer> res = new ArrayList();
        for(int i= 0;i<deck.length;i++){
            if(t!=deck[i]){
                if(t!=-1){
                    res.add(count);
                }
                count = 0;
            }{
                count++;
            }
            t = deck[i];
        }
        res.add(count);
        Collections.sort(res);
        int tp =-1;
        for (int i = 0; i < res.size(); i++) {
            if(i==0){
                tp = res.get(i);
            }
            if(res.get(i)%tp != 0){
                return false;
            }
        }
        return true;
    }
}
