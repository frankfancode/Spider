package com.frankfancode.spider.job51;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.frankfancode.spider.FileUtils;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Created by Frank on 2016/6/10.
 */
public class JobExcel {
    public static void main(String[] args){

        String[] title={"jobName","companyName","companyUrl","companyAddress","workspace","salary"};
        //t.xls为要新建的文件名
        WritableWorkbook book= null;
        try {
            book = Workbook.createWorkbook(new File("t.xls"));
            //生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet=book.createSheet("第一页",0);

//写入内容
            for(int i=0;i<6;i++)    //title
                sheet.addCell(new Label(i,0,title[i]));


            List<JobItem> jobItems = JSON.parseObject(FileUtils.readFromFile(".\\html\\json\\jobDetail.json"), new TypeReference<ArrayList<JobItem>>() {});

//            for(int i=0;i<jobItems.size();i++)    //context
//            {
//                for(int j=0;j<6;j++)
//                {
//                    sheet.addCell(new Label(j+1,i+1,context[i][j]));
//                }
//            }


            Field[] fields=null;
            int i=1;
            for(Object obj:jobItems){
                fields=obj.getClass().getDeclaredFields();
                int j=0;
                for(Field v:fields){
                    v.setAccessible(true);
                    Object va=v.get(obj);
                    if(va==null){
                        va="";
                    }
                    sheet.addCell(new Label(j, i,va.toString()));
                    j++;
                }
                i++;
            }
            /** **********将以上缓存中的内容写到EXCEL文件中******** */
            book.write();
            /** *********关闭文件************* */
            book.close();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
