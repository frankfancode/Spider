package com.frankfancode.spider;

import java.io.*;

/**
 * Created by Frank on 2016/6/9.
 */
public class FileUtils {

    public static boolean writeToFile(String fileName, String s) {
        System.out.println(fileName);
        File file = new File(fileName);// 要写入的文本文件
        //".\\html\\" + fileName + ".txt"
        FileWriter writer = null;
        try {
            if (!file.exists()) {// 如果文件不存在，则创建该文件
                file.createNewFile();
            }
            writer = new FileWriter(file);// 获取该文件的输出流
            writer.write(s);// 写内容
            writer.flush();// 清空缓冲区，立即将输出流里的内容写到文件里
            writer.close();// 关闭输出流，施放资源
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    /**
     * DOC 从文件里读取数据.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String readFromFile(String pathName) {
        File file = new File(pathName);// 指定要读取的文件
        FileReader reader = null;// 获取该文件的输入流
        try {
            reader = new FileReader(file);
            char[] bb = new char[1024];// 用来保存每次读取到的字符
            String str = "";// 用来将每次读取到的字符拼接，当然使用StringBuffer类更好
            int n;// 每次读取到的字符长度
            while ((n = reader.read(bb)) != -1) {
                str += new String(bb, 0, n);
            }
            reader.close();// 关闭输入流，释放连接
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
