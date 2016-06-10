package com.frankfancode.spider.job51;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.frankfancode.spider.FileUtils;
import org.jsoup.helper.StringUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxd on 16/6/7.
 */
public class Job51AddressProcessor implements PageProcessor {
    static List<JobItem> jobItems;
    static List<String> addressList = new ArrayList<>();
    static List<String> urls = new ArrayList<>();
    static Spider spider;
    int i = -1;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(300);

    public static void main(String[] args) {
        //Spider.create(new MySpider()).addUrl("https://github.com/code4craft").thread(5).run();
        spider = Spider.create(new Job51AddressProcessor());

        jobItems = JSON.parseObject(FileUtils.readFromFile(".\\html\\json\\jobItems.json"), new TypeReference<ArrayList<JobItem>>() {
        });

        for (JobItem jobItem : jobItems) {
            urls.add(jobItem.jobUrl);
        }

        spider.startUrls(urls).run();
    }

    @Override
    public void process(Page page) {
        i++;
        String url = page.getUrl().get();
        String[] urlSplits = url.split("/");
        String urlFile = urlSplits[urlSplits.length - 1].split("\\?")[0];
        FileUtils.writeToFile(".\\html\\jobdetail\\" + urlFile, page.getHtml().get());

        System.out.println(i);

        String address = page.getHtml().xpath("//div[@class='bmsg inbox']//p[@class='fp']/text()").get();
        if (StringUtil.isBlank(address)) {
            return;
        }
        addressList.add(address);

        //FileUtils.writeToFile(".\\html\\json\\address.json", JSON.toJSONString(addressList));

        for (JobItem item : jobItems) {
            if (item.jobUrl.trim().equals(url.trim())) {
                item.jobAddress = address;
                FileUtils.writeToFile(".\\html\\json\\JobDetailJobAddress.json", JSON.toJSONString(jobItems));
            }
        }


    }

    @Override
    public Site getSite() {
        return site;
    }


}
