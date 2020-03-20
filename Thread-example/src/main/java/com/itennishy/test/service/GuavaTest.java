package com.itennishy.test.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class GuavaTest {
    public static void main(String[] args) {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s;
            }
        });
        cache.put("a","1");
        cache.put("b","1");
        cache.put("c","1");
        cache.put("a","2");
        try {
            System.out.println(cache.get("a"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new LinkedList<>();



    }
}
