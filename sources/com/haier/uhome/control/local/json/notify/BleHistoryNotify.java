package com.haier.uhome.control.local.json.notify;

import com.haier.uhome.control.local.a.a;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleHistoryNotify extends BasicNotify {

    @b(name = "currentCount")
    private int currentCount;

    @b(name = "devId")
    private String devId;

    @b(name = "historyData")
    private String historyData;

    @b(name = "totalCount")
    private int totalCount;

    public int getCurrentCount() {
        return this.currentCount;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getHistoryData() {
        return this.historyData;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new a();
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setCurrentCount(int i7) {
        this.currentCount = i7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setHistoryData(String str) {
        this.historyData = str;
    }

    public void setTotalCount(int i7) {
        this.totalCount = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BleHistoryNotify{devId='" + this.devId + "', currentCount='" + this.currentCount + "', totalCount='" + this.totalCount + "', historyData='" + this.historyData + "'}";
    }
}
