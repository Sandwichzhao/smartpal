package com.smartpal.inputorder.domain;

import com.smartpal.inputorder.bean.BaseInputOrderInfo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "input_pay")
public class InputPayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "need_pay")
    private float needPay;

    @Column(name = "already_pay")
    private float alreadyPay;

    @Column(name = "remain_pay")
    private float remainPay;

    @Column(name = "status")
    private int status;

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float getNeedPay() {
        return needPay;
    }

    public void setNeedPay(float needPay) {
        this.needPay = needPay;
    }

    public float getAlreadyPay() {
        return alreadyPay;
    }

    public void setAlreadyPay(float alreadyPay) {
        this.alreadyPay = alreadyPay;
    }

    public float getRemainPay() {
        return remainPay;
    }

    public void setRemainPay(float remainPay) {
        this.remainPay = remainPay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}