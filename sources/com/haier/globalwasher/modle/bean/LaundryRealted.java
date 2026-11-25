package com.haier.globalwasher.modle.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LaundryRealted implements Serializable {
    private ArrayList<LaundryActivityInfo> activityList;
    private String distance;
    private LaundryInfo laundry;

    public ArrayList<LaundryActivityInfo> getActivityList() {
        return this.activityList;
    }

    public String getDistance() {
        return this.distance;
    }

    public LaundryInfo getLaundry() {
        return this.laundry;
    }

    public void setActivityList(ArrayList<LaundryActivityInfo> arrayList) {
        this.activityList = arrayList;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setLaundry(LaundryInfo laundryInfo) {
        this.laundry = laundryInfo;
    }

    public String toString() {
        return "LaundryRealted{laundry=" + this.laundry + ", distance='" + this.distance + "', activityList=" + this.activityList + '}';
    }
}
