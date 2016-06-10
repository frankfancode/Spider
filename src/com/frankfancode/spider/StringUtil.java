package com.frankfancode.spider;

/**
 * Created by Frank on 2016/6/10.
 */
public class StringUtil {

    public static boolean isEmpty() {

        return true;
    }

    public static String trimAll(String s) {

        if (null != s) {
            s = s.replace(" ", "");
        }
        return s;
    }

}
