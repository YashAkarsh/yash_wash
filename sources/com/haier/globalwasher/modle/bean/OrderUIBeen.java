package com.haier.globalwasher.modle.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class OrderUIBeen {
    private String address;
    private String deviceName;
    private String deviceNum;
    private String floor;
    private ArrayList<OrderDetailUIBeen> listData;
    private int orderstuta;
    private String washername;

    public OrderUIBeen(int i7, String str, String str2, String str3, String str4, String str5, ArrayList<OrderDetailUIBeen> arrayList) {
        this.orderstuta = i7;
        this.washername = str;
        this.deviceNum = str2;
        this.floor = str3;
        this.deviceName = str4;
        this.address = str5;
        this.listData = arrayList;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceNum() {
        return this.deviceNum;
    }

    public String getFloor() {
        return this.floor;
    }

    public ArrayList<OrderDetailUIBeen> getListData() {
        return this.listData;
    }

    public int getOrderstuta() {
        return this.orderstuta;
    }

    public String getWashername() {
        return this.washername;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceNum(String str) {
        this.deviceNum = str;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setListData(ArrayList<OrderDetailUIBeen> arrayList) {
        this.listData = arrayList;
    }

    public void setOrderstuta(int i7) {
        this.orderstuta = i7;
    }

    public void setWashername(String str) {
        this.washername = str;
    }
}
