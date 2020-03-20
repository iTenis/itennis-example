package com.itennishy.example.随机.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ServerIps {
    public static final Map<String, Integer> IPMAPS = new LinkedHashMap<String,Integer>();
    static {
        IPMAPS.put("192.168.0.1",1);
        IPMAPS.put("192.168.0.2",1);
        IPMAPS.put("192.168.0.3",1);
        IPMAPS.put("192.168.0.4",1);
        IPMAPS.put("192.168.0.5",5);
        IPMAPS.put("192.168.0.6",6);
        IPMAPS.put("192.168.0.7",7);
        IPMAPS.put("192.168.0.8",8);
        IPMAPS.put("192.168.0.9",9);
        IPMAPS.put("192.168.0.10",10);
    }

}
