package com.smartpal.monitor.bean;

import java.sql.Timestamp;

public class StoreGoods {
    private long goodsPk;
    private String snapshopTime;
    private String name;
    private String pirce;
    private String url;
    private String statement;
    private Timestamp updateAt;

    public StoreGoods() {
    }

    public StoreGoods(long goodsPk, String snapshopTime, String name, String pirce, String url, String statement, Timestamp updateAt) {
        this.goodsPk = goodsPk;
        this.snapshopTime = snapshopTime;
        this.name = name;
        this.pirce = pirce;
        this.url = url;
        this.statement = statement;
        this.updateAt = updateAt;
    }

    public long getGoodsPk() {
        return goodsPk;
    }

    public void setGoodsPk(long goodsPk) {
        this.goodsPk = goodsPk;
    }

    public String getSnapshopTime() {
        return snapshopTime;
    }

    public void setSnapshopTime(String snapshopTime) {
        this.snapshopTime = snapshopTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPirce() {
        return pirce;
    }

    public void setPirce(String pirce) {
        this.pirce = pirce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
