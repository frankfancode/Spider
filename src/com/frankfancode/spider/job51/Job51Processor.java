package com.frankfancode.spider.job51;

import com.frankfancode.spider.FileUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by fxd on 16/6/7.
 */
public class Job51Processor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public static void main(String[] args) {

        //前端一年经验以上的职位
        String url_QianDuan = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=120300%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=%E5%89%8D%E7%AB%AF&keywordtype=2&curr_page=1&lang=c&stype=1&postchannel=0000&workyear=05%2C04%2C03%2C02&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&dibiaoid=0&confirmdate=9";
        //Android
        String url_Android = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=120300%2C00&district=000000&funtype=2600%2C0100%2C2500%2C2700&industrytype=00&issuedate=9&providesalary=99&keyword=Android&keywordtype=2&curr_page=1&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9";


        Spider.create(new Job51Processor()).addUrl(url_Android ).run();
    }

    @Override
    public void process(Page page) {

        String pageIndex = page.getHtml().xpath("//li[@class='on']/text(1)").get();
        FileUtils.writeToFile(".\\html\\joblist\\"+pageIndex+".html", page.getHtml().toString());


        List<String> urls = page.getHtml().xpath("//div[@class='p_in']//li[@class='bk']").links().all();
        if (urls.size() > 0) {
            String nextPageUrl = urls.get(urls.size() - 1);
            page.addTargetRequest(nextPageUrl);
            System.out.println(nextPageUrl);
        }


    }

    @Override
    public Site getSite() {
        return site;
    }


}
