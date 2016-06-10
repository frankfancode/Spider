package com.frankfancode.spider.entity;

import java.util.List;

/**
 * Created by Frank on 2016/6/10.
 */
public class LocationMaker {

    /**
     * errorno : 0
     * total : 5365
     * NearestTime : 2014-08-29 15:20:00
     * data : [[74.438,39.006,1],[74.932,38.382,1],[75.402,37.879,1],[75.24,38.777,1],[75.264,39.656,1],[121.616,24.021,1],[121.541,25.044,1],[121.708,25.087,1],[121.817,25.025,1]]
     * userTime : 2014-08-29 15:32:11
     * rt_loc_cnt : 47764510
     */
    private int errorno;
    private int total;
    private String NearestTime;
    private List<List<Double>> data;
    private String userTime;
    private int rt_loc_cnt;

    public void setErrorno(int errorno) {
        this.errorno = errorno;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setNearestTime(String NearestTime) {
        this.NearestTime = NearestTime;
    }

    public void setData(List<List<Double>> data) {
        this.data = data;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public void setRt_loc_cnt(int rt_loc_cnt) {
        this.rt_loc_cnt = rt_loc_cnt;
    }

    public int getErrorno() {
        return errorno;
    }

    public int getTotal() {
        return total;
    }

    public String getNearestTime() {
        return NearestTime;
    }

    public List<List<Double>> getData() {
        return data;
    }

    public String getUserTime() {
        return userTime;
    }

    public int getRt_loc_cnt() {
        return rt_loc_cnt;
    }
}
