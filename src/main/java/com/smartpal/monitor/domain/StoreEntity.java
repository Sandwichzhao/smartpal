package com.smartpal.monitor.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="store")
public class StoreEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;

    @Column(name = "name")
    private String name;

    @Column(name="note")
    private String note;

    @Column(name="url")
    private String url;

    @Column(name="status")
    private int status;

    @Column(name="created_at", updatable=false)
    private Timestamp createdAt;

    @Column(name="updated_at")
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
