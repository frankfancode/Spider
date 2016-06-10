package com.frankfancode.spider.job51;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.frankfancode.spider.FileUtils;
import com.frankfancode.spider.Key;
import com.frankfancode.spider.entity.GaoDeResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2016/6/10.
 */
public class Job51AddressGeo {
    //http://restapi.amap.com/v3/geocode/geo?key=8cf186d451d7c3a18f60e0267b44bcbe&address=%E5%8C%97%E4%BA%AC%E5%A4%A9%E5%AE%89%E9%97%A8
    public static void main(String[] args) {
        System.out.println("start");

        List<JobItem> jobItemList = JSON.parseObject(FileUtils.readFromFile(".\\html\\json\\JobDetailJobAddress.json"), new TypeReference<ArrayList<JobItem>>() {
        });

        for (JobItem item : jobItemList) {
            String params = "key="+ Key.gaodeKey+"&address=山东省青岛市" + com.frankfancode.spider.StringUtil.trimAll(item.jobAddress);
            item.jobLocation = getLocation("http://restapi.amap.com/v3/geocode/geo?" + params);

            FileUtils.writeToFile(".\\html\\json\\JobDetailJobAddressLocation.json", JSON.toJSONString(jobItemList));
        }


    }


    private static String getLocation(String url) {
        System.out.println(url);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(url);

            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity());


            GaoDeResponse gaoDerespuesta = JSON.parseObject(json, GaoDeResponse.class);

            System.out.print(json);

            if (gaoDerespuesta != null && gaoDerespuesta.getGeocodes().size() > 0) {
                return gaoDerespuesta.getGeocodes().get(0).getLocation();
            }


        } catch (IOException ex) {
        }
        return "";
    }

}
