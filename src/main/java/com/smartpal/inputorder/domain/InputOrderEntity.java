package com.smartpal.inputorder.domain;

import com.smartpal.inputorder.bean.BaseInputOrderInfo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "input_order")
public class InputOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private int number;

    @Column(name = "price")
    private float price;

    @Column(name = "statement")
    private String statement;

    @Column(name = "status")
    private int status;

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public InputOrderEntity() {
    }

    public InputOrderEntity(BaseInputOrderInfo baseInputOrderInfo) {
        this.id = baseInputOrderInfo.getId();
        this.serialNumber = baseInputOrderInfo.getSerialNumber();
        this.userId = baseInputOrderInfo.getUserId();
        this.address = baseInputOrderInfo.getAddress();
        this.number = baseInputOrderInfo.getNumber();
        this.status = baseInputOrderInfo.getStatus();
        this.price = baseInputOrderInfo.getPrice();
        this.statement = baseInputOrderInfo.getStatement();
        this.createdAt = baseInputOrderInfo.getCreatedAt();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}