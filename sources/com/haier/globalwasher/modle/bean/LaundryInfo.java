package com.haier.globalwasher.modle.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LaundryInfo implements Serializable {
    private ArrayList<LaundryActivityInfo> activityList;
    private String address;
    private String businessId;
    private String businessStatus;
    private ArrayList<String> floorNumbers;
    private String hotLine;
    private String latitude;
    private String laundryId;
    private String longitude;
    private String name;
    private String notice;
    private String payWindowTotalTime;
    private ArrayList<String> picture;
    private String spareDeviceNumber;
    private String weekEndTime;
    private String weekStartTime;
    private String workEndTime;
    private String workStartTime;

    public ArrayList<LaundryActivityInfo> getActivityList() {
        return this.activityList;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public String getBusinessStatus() {
        return this.businessStatus;
    }

    public ArrayList<String> getFloorNumbers() {
        return this.floorNumbers;
    }

    public String getHotLine() {
        return this.hotLine;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLaundryId() {
        return this.laundryId;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPayWindowTotalTime() {
        return this.payWindowTotalTime;
    }

    public ArrayList<String> getPicture() {
        return this.picture;
    }

    public String getSpareDeviceNumber() {
        return this.spareDeviceNumber;
    }

    public String getWeekEndTime() {
        return this.weekEndTime;
    }

    public String getWeekStartTime() {
        return this.weekStartTime;
    }

    public String getWorkEndTime() {
        return this.workEndTime;
    }

    public String getWorkStartTime() {
        return this.workStartTime;
    }

    public void setActivityList(ArrayList<LaundryActivityInfo> arrayList) {
        this.activityList = arrayList;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBusinessId(String str) {
        this.businessId = str;
    }

    public void setBusinessStatus(String str) {
        this.businessStatus = str;
    }

    public void setFloorNumbers(ArrayList<String> arrayList) {
        this.floorNumbers = arrayList;
    }

    public void setHotLine(String str) {
        this.hotLine = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLaundryId(String str) {
        this.laundryId = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setPayWindowTotalTime(String str) {
        this.payWindowTotalTime = str;
    }

    public void setPicture(ArrayList<String> arrayList) {
        this.picture = arrayList;
    }

    public void setSpareDeviceNumber(String str) {
        this.spareDeviceNumber = str;
    }

    public void setWeekEndTime(String str) {
        this.weekEndTime = str;
    }

    public void setWeekStartTime(String str) {
        this.weekStartTime = str;
    }

    public void setWorkEndTime(String str) {
        this.workEndTime = str;
    }

    public void setWorkStartTime(String str) {
        this.workStartTime = str;
    }

    public String toString() {
        return "LaundryInfo{longitude='" + this.longitude + "', latitude='" + this.latitude + "', name='" + this.name + "', laundryId='" + this.laundryId + "', address='" + this.address + "', spareDeviceNumber='" + this.spareDeviceNumber + "', picture=" + this.picture + ", floorNumbers=" + this.floorNumbers + ", businessId='" + this.businessId + "', hotLine='" + this.hotLine + "', payWindowTotalTime='" + this.payWindowTotalTime + "', businessStatus='" + this.businessStatus + "', workStartTime='" + this.workStartTime + "', workEndTime='" + this.workEndTime + "', weekStartTime='" + this.weekStartTime + "', weekEndTime='" + this.weekEndTime + "'}";
    }
}
