package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LaundryActivityInfo implements Serializable {
    private String activityPicUrl;
    private double discount;
    private String discountValues;
    private String endDate;
    private String explain;
    private int id;
    private String notice;
    private String title;
    private int type;
    private String typeTitle;
    private int washNumber;

    public String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getDiscountValues() {
        return this.discountValues;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getExplain() {
        return this.explain;
    }

    public int getId() {
        return this.id;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeTitle() {
        return this.typeTitle;
    }

    public int getWashNumber() {
        return this.washNumber;
    }

    public void setActivityPicUrl(String str) {
        this.activityPicUrl = str;
    }

    public void setDiscount(double d8) {
        this.discount = d8;
    }

    public void setDiscountValues(String str) {
        this.discountValues = str;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setExplain(String str) {
        this.explain = str;
    }

    public void setId(int i7) {
        this.id = i7;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i7) {
        this.type = i7;
    }

    public void setTypeTitle(String str) {
        this.typeTitle = str;
    }

    public void setWashNumber(int i7) {
        this.washNumber = i7;
    }

    public String toString() {
        return "LaundryActivityInfo{discount=" + this.discount + ", endDate='" + this.endDate + "', id=" + this.id + ", title='" + this.title + "', type=" + this.type + ", washNumber=" + this.washNumber + ", notice='" + this.notice + "', typeTitle='" + this.typeTitle + "', explain='" + this.explain + "', activityPicUrl='" + this.activityPicUrl + "'}";
    }
}
