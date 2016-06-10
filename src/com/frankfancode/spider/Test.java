package com.frankfancode.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.frankfancode.spider.job51.JobItem;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2016/6/9.
 */
public class Test {
    public static void main(String args[]) {
       
        testJobAddress();

    }

    private static void testJobAddress() {
        String htmlString=FileUtils.readFromFile(".\\html\\59311996.html");
        Html html=Html.create(htmlString);
        String s=html.xpath("//div[@class='bmsg inbox']//p[@class='fp']/text()").toString();
        System.out.println(s);
    }


    public static void get(){
        FileUtils.writeToFile("1", "adasd");
        List<JobItem> jobItems = JSON.parseObject(FileUtils.readFromFile(".\\html\\json\\jobDetail.json"), new TypeReference<ArrayList<JobItem>>() {});
        List<JobItem> notAddress=new ArrayList<>();

        for (JobItem item:jobItems){
            if (null==item.companyAddress||item.companyAddress.trim().equals("")){
                notAddress.add(item);
            }
        }

        FileUtils.writeToFile(".\\html\\json\\JobItemsNotAddress.json", JSON.toJSONString(notAddress));
    }
}
