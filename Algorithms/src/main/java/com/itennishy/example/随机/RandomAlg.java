package com.itennishy.example.随机;

import com.itennishy.example.随机.domain.ServerIps;

import java.util.*;

public class RandomAlg {

    private static String getServer() {
        Boolean withWeight = true;
//        复制法来实现随机，内存开销会增加
//        List<String> ips = new ArrayList<>();

//        for (String ip : ServerIps.IPMAPS.keySet()) {
//            Integer weight = ServerIps.IPMAPS.get(ip);
//            for (int i = 0; i < weight; i++) {
//                ips.add(ip);
//                if (ips != null && ! ips.get(i).equals(ips.get(i - 1))) {
//                    withWeight = true;
//                }
//            }
//        }

        Integer totalWeight = 0;
        Object[] weights = ServerIps.IPMAPS.values().toArray();
        for (int i = 0; i < weights.length; i++) {
            totalWeight += (Integer) weights[i];
            if (withWeight && i > 0 && weights[i].equals(weights[i - 1])) {
                withWeight = false;
            }
        }
        int offset = new Random().nextInt(totalWeight);
        System.out.println(withWeight + ":" + totalWeight);
        if (withWeight) {
            for (String ip : ServerIps.IPMAPS.keySet()) {
                Integer weight = ServerIps.IPMAPS.get(ip);
                if (offset < weight) {
                    return ip;
                } else {
                    offset -= weight;
                }
            }
        }
        return (String) ServerIps.IPMAPS.keySet().toArray()[offset];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }


}
