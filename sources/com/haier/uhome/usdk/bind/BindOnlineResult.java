package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class BindOnlineResult {

    @g3.b(name = "bts")
    long bts;

    @g3.b(name = com.haier.globalwasher.presenter.o.f25218y)
    String deviceId;

    @g3.b(name = "onLine")
    int onLine;

    @g3.b(name = "uplusID")
    String uplusId;

    public long getBts() {
        return this.bts;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getOnLine() {
        return this.onLine;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setBts(long j7) {
        this.bts = j7;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setOnLine(int i7) {
        this.onLine = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    public String toString() {
        return "BindOnlineResult{bts=" + this.bts + ", deviceId='" + this.deviceId + "', onLine=" + this.onLine + ", uplusId='" + this.uplusId + "'}";
    }
}
