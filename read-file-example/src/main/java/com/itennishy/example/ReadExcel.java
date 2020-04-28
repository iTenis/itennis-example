package com.itennishy.example;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.bson.Document;

import java.util.*;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-27 10:14
 */
public class ReadExcel {

    public static void main(String[] args) {
        MongoDBUtils.bsonConnectUrl("dev", "sellcount_anchor", "mongodb://root:Yicai123@dds-bp1ed26b3daafb041664-pub.mongodb.rds.aliyuncs.com:3717,dds-bp1ed26b3daafb042186-pub.mongodb.rds.aliyuncs.com:3717/wawo-dev?replicaSet=mgset-12907627&authMechanism=SCRAM-SHA-1&authSource=admin");
        MongoDBUtils.connectUrl("dev", "sellcount_anchor", "mongodb://root:Yicai123@dds-bp1ed26b3daafb041664-pub.mongodb.rds.aliyuncs.com:3717,dds-bp1ed26b3daafb042186-pub.mongodb.rds.aliyuncs.com:3717/wawo-dev?replicaSet=mgset-12907627&authMechanism=SCRAM-SHA-1&authSource=admin");

//        FileReader fileReader = new FileReader(System.getProperty("user.dir")+"/read-file-example/30分钟主播清单20200426.txt");
//        String result = fileReader.readString();
//        String[] split = result.split("\n");
//        System.out.println(split.length);
//        for (String s : split) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("_id", s.trim() + ":" + 1800);
//            map.put("anchorId", s.trim());
//            map.put("interval", 1800);
//            map.put("typeCode", 99);
//            MongoDBUtils.insert(new Document(map));
//            System.out.println(s);
//        }

//        Document typeCode = new Document().append("typeCode", 600);
//        MongoDBUtils.deleteMany(typeCode);

        ExcelReader reader1 = ExcelUtil.getReader(System.getProperty("user.dir")+"/read-file-example/1分钟主播清单20200426.xlsx");
        ExcelReader reader2 = ExcelUtil.getReader(System.getProperty("user.dir")+"/read-file-example/5分钟最新主播清单20200426.xlsx");
        ExcelReader reader3 = ExcelUtil.getReader(System.getProperty("user.dir") + "/read-file-example/10分钟主播清单20200426.xlsx");
        ExcelReader reader4 = ExcelUtil.getReader(System.getProperty("user.dir")+"/read-file-example/10秒主播清单20200426.xlsx");
        List<List<Object>> read1All = reader1.read();
        List<List<Object>> read2All = reader2.read();
        List<List<Object>> read3All = reader3.read();
        List<List<Object>> read4All = reader4.read();
        Set<String> read1Set = new HashSet<>();
        Set<String> read2Set = new HashSet<>();
        Set<String> read3Set = new HashSet<>();
        Set<String> read4Set = new HashSet<>();
        for (List<Object> objects : read1All) {
            if ("主播ID".equals(objects.get(0))) {
                continue;
            }
            read1Set.add(objects.get(0).toString());
        }
        for (List<Object> objects : read2All) {
            if ("主播ID".equals(objects.get(0))) {
                continue;
            }
            read2Set.add(objects.get(0).toString());
        }
        for (List<Object> objects : read3All) {
            if ("主播ID".equals(objects.get(0))) {
                continue;
            }
            read3Set.add(objects.get(0).toString());
        }
        for (List<Object> objects : read4All) {
            if ("主播ID".equals(objects.get(0))) {
                continue;
            }
            read4Set.add(objects.get(0).toString());
        }


        Set<String> readAllSet = new HashSet<>();
        readAllSet.addAll(read1Set);
        readAllSet.addAll(read2Set);
        readAllSet.addAll(read3Set);
        readAllSet.addAll(read4Set);
        readAllSet.removeAll(read1Set);
        readAllSet.removeAll(read2Set);
        readAllSet.removeAll(read4Set);
        System.out.println(readAllSet.size());

        for (String id: readAllSet) {

            Map<String, Object> map = new HashMap<>();
            map.put("_id", id + ":" + 600);
            map.put("anchorId", id);
            map.put("interval", 600);
            map.put("typeCode", 600);
            MongoDBUtils.insert(new Document(map));
            System.out.println(map);
        }



//        for (List<Object> objects : readAll) {
//            if ("主播ID".equals(objects.get(0))) {
//                continue;
//            }
//            Map<String, Object> map = new HashMap<>();
//            map.put("_id", objects.get(0) + ":" + 600);
//            map.put("anchorId", objects.get(0).toString());
//            map.put("interval", 600);
//            map.put("typeCode", 600);
//            MongoDBUtils.insert(new Document(map));
//            System.out.println(map);
//        }


//        MongoDBUtils.connectUrl("main", "sellcount_anchor", "mongodb://root:Yicai123@dds-bp1ed26b3daafb041664-pub.mongodb.rds.aliyuncs.com:3717,dds-bp1ed26b3daafb042186-pub.mongodb.rds.aliyuncs.com:3717/wawo-dev?replicaSet=mgset-12907627&authMechanism=SCRAM-SHA-1&authSource=admin");
//        MongoDBUtils.bsonConnectUrl("main", "sellcount_anchor", "mongodb://root:Yicai123@dds-bp1ed26b3daafb041664-pub.mongodb.rds.aliyuncs.com:3717,dds-bp1ed26b3daafb042186-pub.mongodb.rds.aliyuncs.com:3717/wawo-dev?replicaSet=mgset-12907627&authMechanism=SCRAM-SHA-1&authSource=admin");
//        Document filter = new Document();
//        filter.append("typeCode", 99);
//        List<Document> documents = MongoDBUtils.findBy(filter);
//        System.out.println(documents.size());
//        FileWriter writer = new FileWriter(System.getProperty("user.dir")+"/read-file-example/30分钟主播清单20200426.txt");
//        for (Document document : documents) {
//
//            writer.append(document.getString("anchorId")+"\n");
//            List<String> objects = new ArrayList<>();
//            objects.add(document.getString("anchorId"));
//            writer.write(objects);
//            System.out.println(document.getString("anchorId"));
//        }

//            Map<String, Object> map = new HashMap<>();
//            map.put("_id", document.getString("anchorId") + ":" + 99);
//            map.put("anchorId", document.getString("anchorId"));
//            map.put("interval", 1800);
//            map.put("typeCode", 99);
//            MongoDBUtils.insert(new Document(map));
//        }

    }
}
