package com.frankfancode.spider.job51;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.frankfancode.spider.FileUtils;
import com.frankfancode.spider.entity.LocationMaker;
import com.frankfancode.spider.job51.JobItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Frank on 2016/6/10.
 */
public class GenerateMakerList {
    public static void main(String[] args) {
        System.out.println("start");

        List<JobItem> jobItemList = JSON.parseObject(FileUtils.readFromFile(".\\html\\json\\JobDetailJobAddressLocation.json"), new TypeReference<ArrayList<JobItem>>() {
        });

        LocationMaker maker = new LocationMaker();

        List<List<Double>> locationList = new LinkedList<>();

        for (JobItem item : jobItemList) {

            String[] location = item.jobLocation.split(",");

            List<Double> doubleList = new LinkedList<>();
            doubleList.add(Double.valueOf(location[0]));
            doubleList.add(Double.valueOf(location[1]));
            doubleList.add(Double.valueOf(1));
            locationList.add(doubleList);


        }

        maker.setData(locationList);
        FileUtils.writeToFile(".\\html\\json\\maker.json", JSON.toJSONString(maker));


    }
}
