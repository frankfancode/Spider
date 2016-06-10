package com.frankfancode.spider.job51;

import com.alibaba.fastjson.JSON;
import com.frankfancode.spider.FileUtils;
import org.jsoup.helper.StringUtil;
import us.codecraft.webmagic.selector.Html;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Frank on 2016/6/9.
 */
public class Job51HtmlParser {

    public static void main(String args[]) {
        Html html = null;
        List<JobItem> jobItems = new LinkedList<>();

        for (int pageIndex =1; pageIndex < 100; pageIndex++) {
            String pathName = ".\\html\\joblist\\" + pageIndex + ".html";
            String htmlString = FileUtils.readFromFile(pathName);
            if (!StringUtil.isBlank(htmlString)) {
                html = Html.create(htmlString);
                jobItems.addAll(parserHtml(html));
            } else {
                break;
            }


        }

        FileUtils.writeToFile(".\\html\\json\\jobItems.json",JSON.toJSONString(jobItems));

    }


    private static List<JobItem> parserHtml(Html html) {


        if (html != null) {
            List<String> elList;
            elList = html.xpath("//div[@id='resultList']/div[@class='el']").all();

            List<JobItem> jobItems = new LinkedList<>();
            for (String el : elList) {
                Html elhtml = Html.create(el);
                if (elhtml.xpath("//div[@class='title']").match()) {
                    continue;
                }

                JobItem jobItem = new JobItem();
                jobItem.jobUrl= elhtml.links().all().get(0);
                jobItem.companyUrl = elhtml.links().all().get(1);

                List<String> spanList = elhtml.xpath("//span/allText()").all();

                jobItem.jobName = spanList.get(0);
                jobItem.companyName = spanList.get(1);
                jobItem.workspace = spanList.get(2);
                jobItem.salary = spanList.get(3);


                jobItems.add(jobItem);

            }

            return jobItems;


        }

        return null;
    }


}
