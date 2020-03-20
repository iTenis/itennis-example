package com.itennishy.test.service;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

    public static void main(String[] args) {

        BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(),10000000,0.001);
        for(int i=0;i<1000000;i++){
            bloomFilter.put(i);
        }
        System.out.println(bloomFilter.mightContain(11000000));
    }
}
