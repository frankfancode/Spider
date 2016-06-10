package com.frankfancode.spider;

import com.frankfancode.spider.job51.Job51Processor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class MySpider implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        page.putField("address", page.getHtml().xpath("//h1[@class='dw_table el']/span/text()").all());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            //    page.setSkip(true);
        }
        // page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //Spider.create(new MySpider()).addUrl("https://github.com/code4craft").thread(5).run();
        Spider.create(new Job51Processor()).addUrl("http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=120300%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=%E5%89%8D%E7%AB%AF&keywordtype=2&curr_page=1&lang=c&stype=1&postchannel=0000&workyear=05%2C04%2C03%2C02&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&dibiaoid=0&confirmdate=9")
                .addPipeline(new JsonFilePipeline("/Users/fxd/private/project/spider//"))
                .run();
    }

}
