package com.smartpal.monitor.bean;

public class Store {
    private long pk;
    private String name;
    private String note;
    private String url;

    public Store() {
    }

    public Store(long pk, String name, String note) {
        this.pk = pk;
        this.name = name;
        this.note = note;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
