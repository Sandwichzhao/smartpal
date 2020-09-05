package com.smartpal.monitor.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="goods")
public class GoodsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;
    @Column(name = "store_id")
    private long storePk;

    @Column(name = "snapshop_time")
    private String snapshopTime;

    @Column(name = "name")
    private String name;

    @Column(name="pirce")
    private String pirce;

    @Column(name="url")
    private String url;

    @Column(name="statement")
    private String statement;

    @Column(name="created_at", updatable=false)
    private Timestamp createdAt;

    @Column(name="update_at")
    private Timestamp updateAt;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public long getStorePk() {
        return storePk;
    }

    public void setStorePk(long storePk) {
        this.storePk = storePk;
    }

    public String getSnapshopTime() {
        return snapshopTime;
    }

    public void setSnapshopTime(String snapshopTime) {
        this.snapshopTime = snapshopTime;
    }
}
